package com.online.edu.controller;


import com.online.edu.pojo.CourseClass;
import com.online.edu.pojo.User;
import com.online.edu.service.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseClassService cCs;

    @RequestMapping("/info")
    public String showClassInfo(@RequestParam("id")int teacherid, Model model){

       List<CourseClass> classnamelist = cCs.selectCourseByThrId(teacherid);
        System.out.println(classnamelist);
        model.addAttribute("classnamelist",classnamelist);
        return "teacher";
    }




}
