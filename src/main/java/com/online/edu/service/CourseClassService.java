package com.online.edu.service;


import com.online.edu.pojo.CourseClass;

import java.util.List;

public interface CourseClassService {

    List<CourseClass> selectCourse(int courseid);
    int addCourse(CourseClass courseClass);//添加班级课程信息
    int updateCourse(CourseClass courseClass);//更新课程信息
    int deleteCourse(int id);//删除课程
    List<CourseClass> selectCourseByThrId(int teacherid);//根据教师id查询其所有课程
}
