package com.online.edu.controller;


import com.online.edu.pojo.CourseWare;
import com.online.edu.service.CourseWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class CourseFileController {

    @Autowired
    private CourseWareService courseWareService;

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        //上传文件大小 50M 50*1024*1024
        resolver.setMaxUploadSize(50*1024*1024);
        return resolver;
    }


    //文件上传实现
    @PostMapping("upload")
    @ResponseBody
    public String upload (@RequestParam("file") @Autowired MultipartFile file) throws UnsupportedEncodingException, ParseException {
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        fileName.getBytes("UTF-8");
        System.out.println(fileName);
        String name = fileName;
        // 文件保存路径
        String filePath = "H:/计算机/大四一学期/计算机综合实训/upload/";
        // 文件重命名，防止重复
        fileName = filePath  + fileName;
        // 文件对象
        File dest = new File(fileName);

        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = sdf.parse(nowTime);
//        System.out.println(TIME.format(new Date()));// new Date()为获取当前系统时间
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            courseWareService.insertFile(name,filePath,time);
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
    @RequestMapping("select")
    public String selectList(Model model){
        List lists= courseWareService.SelcetList();
        System.out.println(lists);
        model.addAttribute("lists",lists);
        return "upload";
    }


    @RequestMapping("download")
    public void down(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String fileName = request.getSession().getServletContext().getRealPath("WEB-INF/upload/2020/1")+"/sliver20200115164910583.txt";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }


    @RequestMapping("index")
    public String uploadFile(){
        return "upload";
    }
}