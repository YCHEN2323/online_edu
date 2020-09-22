package com.online.edu.service.impl;

import com.online.edu.dao.CourseClassDao;
import com.online.edu.pojo.CourseClass;
import com.online.edu.service.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseClassService")
public class CourseClassServiceImpl implements CourseClassService {

    @Autowired
    private CourseClassDao courseClassDao;


    @Override
    public List<CourseClass> selectCourse(int courseid) {
        return courseClassDao.selectCourse(courseid);
    }

    @Override
    public int addCourse(CourseClass courseClass) {
        courseClassDao.addCourse(courseClass);
        return 0;
    }

    @Override
    public int updateCourse(CourseClass courseClass) {
        courseClassDao.updateCourse(courseClass);
        return 0;
    }

    @Override
    public int deleteCourse(int id) {
        courseClassDao.deleteCourse(id);
        return 0;
    }

    @Override
    public List<CourseClass> selectCourseByThrId(int teacherid) {

        return courseClassDao.selectCourseByThrId(teacherid);
    }
}
