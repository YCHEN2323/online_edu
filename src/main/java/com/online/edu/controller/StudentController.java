package com.online.edu.controller;

import com.online.edu.pojo.Student;
import com.online.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/select")
    public String SelectStudentById(@RequestParam("id") int id, Model model, HttpSession session) {
        Student student = studentService.selectFromId(id);
        model.addAttribute("msg", "信息查询成功！");
        session.setAttribute("student",student);
        System.out.println(student);
        return "sucess";
    }
    @GetMapping("/login")
    public String loginSelect(@RequestParam("name")String loginname,@RequestParam("pswd") String password, Model model,HttpSession session){
        Student student = studentService.loginSelect(loginname,password);
        System.out.println(student);
        if(student.getLoginname().equals(loginname)){
            if (student.getPassword().equals(password)){
                session.setAttribute("user",student);
            }else { model.addAttribute("msg","用户名错误，请检查后输入！");
                    return "login";}
        }else {model.addAttribute("msg","密码错误！");
                    return "login";}
        return "sucess";
    }


    @RequestMapping("/index")
    public String view() {
        return "login";
    }

//    public int doJudge(@RequestParam("sex") String sex) {
//        String gender = "男";
//        int stu_gender;
//        if (sex.equals(gender)) {
//            stu_gender = 1;
//        } else {
//            stu_gender = 0;
//        }
//        return stu_gender;
//    }
}
