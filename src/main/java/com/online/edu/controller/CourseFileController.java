package com.online.edu.controller;

import com.online.edu.pojo.CourseWare;
import com.online.edu.service.CourseWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class CourseFileController {

    @Autowired
    private CourseWareService courseWareService;


    @RequestMapping("upload")
    @ResponseBody
    public String upload (@RequestParam("file") MultipartFile file) throws UnsupportedEncodingException {
        // 获取原始名字
        String fileName =new String(file.getOriginalFilename().getBytes(),"ISO_8859_1");
        String name =new String(file.getOriginalFilename().getBytes(),"ISO_8859_1");
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        String filePath = "D:/IntelliJ IDEA/IdeaProjects/online_edu/src/main/resources/upload/";
        // 文件重命名，防止重复
        fileName = filePath + UUID.randomUUID() + fileName;
        // 文件对象
        File dest = new File(fileName);
        //时间获取，转为sql时间存入
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//        System.out.println(TIME.format(new Date()));// new Date()为获取当前系统时间
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            courseWareService.insertFile(name,filePath,sqlDate);
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @RequestMapping("index")
    public String uploadFile(){
        return "upload";
    }
}