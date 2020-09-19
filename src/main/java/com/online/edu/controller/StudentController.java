package com.online.edu.controller;

import com.online.edu.pojo.Student;
import com.online.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String SelectStudentById(@RequestParam("stu_id")int stu_id, Model model){
         Student student=  studentService.selectFromId(stu_id);
        model.addAttribute("student",student);
        model.addAttribute("msg","信息查询成功！");
        System.out.println(student);
        return "sucess";
    }

    @RequestMapping("/student/insert")
    public String insert(@RequestParam("stu_name")String stu_name,
                         @RequestParam("stu_number") String stu_number,
                         @RequestParam("sex")String stu_gender,Model model){
        int nub= doJudge(stu_gender);
        Student student= new Student();
        student.setStu_name(stu_name);
        student.setStu_number(stu_number);
        student.setStu_gender(nub);
        studentService.insertInfo(student);
        model.addAttribute("info","学生添加成功！");
        return "sucess";
    }

    @RequestMapping("/index")
    public String view(){
        return "this";
    }
    public int doJudge(@RequestParam("sex")String sex){
        String gender = "男";
        int stu_gender;
        if(sex.equals(gender)){
             stu_gender =1;
        }else {
            stu_gender=0;
        }
    return stu_gender;
    }

}
