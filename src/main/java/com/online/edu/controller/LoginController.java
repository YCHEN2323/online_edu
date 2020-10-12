package com.online.edu.controller;

import com.online.edu.dao.UserDao;
import com.online.edu.entity.User;
import com.online.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/select")
    public String SelectStudentById(@RequestParam("id") int id, Model model, HttpSession session) {
//        User user = userService.selectFromId(id);
        User user = userDao.selectById(id);
        model.addAttribute("msg", "信息查询成功！");
        session.setAttribute("student", user);
        System.out.println(user);
        return "/sucess";
    }
    private int tp;

    @RequestMapping("/in")
    public ModelAndView loginSelect(@RequestParam("name") String loginname,
                                    @RequestParam("pswd") String password,
                                     Model model, ModelAndView mv, HttpSession session) {
//        User user = userService.loginSelect(loginname, password);
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("loginname",loginname);
        conditions.put("password",password);
        List<User> userList = userDao.selectByMap(conditions);
        System.out.println(userList);
        User usertype = new User();
        for(User user : userList) {
          tp = user.getType();
            usertype.setId(user.getId());
            usertype.setLoginname(user.getLoginname());
            usertype.setType(user.getType());
        }
        if (userList.isEmpty()){
            mv.setView(new RedirectView("/index"));
           session.setAttribute("errorInfo","用户信息未在数据库中检索到，请核对用户名和密码！");
            return mv;
        }else if (tp == 1){
            session.setAttribute("user", usertype);
                mv.setView(new RedirectView("/teacher?id=" ));
                session.setAttribute("id", usertype.getId());
                session.setAttribute("name", usertype.getName());
                session.setAttribute("type", "教师");
                model.addAttribute("user", usertype);
        }else{
            session.setAttribute("user", usertype);
                mv.setView(new RedirectView("/student?id=" + usertype.getId()));
                session.setAttribute("id", usertype.getId());
                session.setAttribute("name", usertype.getName());
                session.setAttribute("type", "学生");
                model.addAttribute("user", usertype);
        }

        return mv;
    }
//前台登录输入姓名时进行前台ajax异步查询，检查用户名，提升交互体验
    @GetMapping("/user/name")
    @ResponseBody
    public String checkNameNoF(String name){
        Map<String, Object> map = new HashMap<>();
        map.put("loginname",name);
        System.out.println("前端用户为："+name);
        List<User> userList = userDao.selectByMap(map);
        if(userList.isEmpty()){
          return "用户未注册，请检查用户名";
        }else {
           return "用户验证通过";
        }
    }
    //前台登录输入姓名时进行前台ajax异步查询，检查密码，提升交互体验
    @GetMapping("/user/psw")
    @ResponseBody
    public String checkPswNoF(String name,
                            String password){
        Map<String, Object> map = new HashMap<>();
        map.put("loginname",name);
        map.put("password",password);
        System.out.println("前端用户为："+name);
        System.out.println("前端密码为："+password);
        List<User> userList = userDao.selectByMap(map);
        if(userList.isEmpty()){
          return "密码错误，请重新输入密码";
        }else {
           return "密码验证通过！";
        }
    }


    @RequestMapping("/index")
    public String view() {
        return "/login";
    }

    @RequestMapping("/teacher")
    public String t() {
        return "/teacher";
    }

    @RequestMapping("/student")
    public String s() {
        return "/student";
    }

    @RequestMapping("/login")
    public String l() {
        return "/login";
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
