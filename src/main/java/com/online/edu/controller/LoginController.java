package com.online.edu.controller;

import com.online.edu.pojo.User;
import com.online.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public String SelectStudentById(@RequestParam("id") int id, Model model, HttpSession session) {
        User user = userService.selectFromId(id);
        model.addAttribute("msg", "信息查询成功！");
        session.setAttribute("student", user);
        System.out.println(user);
        return "sucess";
    }
    @RequestMapping("/in")
    public ModelAndView loginSelect(@RequestParam("name")String loginname,
                              @RequestParam("pswd") String password,
                              @RequestParam("type") int type,Model model, ModelAndView mv, HttpSession session){
        User user = userService.loginSelect(loginname,password);
        User usertype=userService.userType(loginname,type);
        System.out.println(user);
        if(user.getLoginname().equals(loginname) && user.getPassword().equals(password)){
            if (usertype.getType()==1){
                session.setAttribute("user", usertype);
                mv.setView(new RedirectView("/teacher?id="+usertype.getId()));
                session.setAttribute("id",   usertype.getId());
                session.setAttribute("name",   usertype.getName());
                session.setAttribute("type",   usertype.getType());
                model.addAttribute("user",usertype);
            }else {
                session.setAttribute("user", usertype);
                mv.setView(new RedirectView("/student?id="+usertype.getId()));
                session.setAttribute("id",   usertype.getId());
                session.setAttribute("name",   usertype.getName());
                session.setAttribute("type",   usertype.getType());
                model.addAttribute("user",usertype);
            }

        }else {
            mv.setView(new RedirectView("login"));
            model.addAttribute("msg","用户名或者密码错误，请检查后输入！");
            }
        return mv;
    }


    @RequestMapping("/index")
    public String view() {
        return "login";
    }

    @RequestMapping("/teacher")
    public String t() {
        return "teacher";
    }


    @RequestMapping("/student")
    public String s() {
        return "student";
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
