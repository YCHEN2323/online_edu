package com.online.edu.dao;


import com.online.edu.pojo.CourseStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseStudentDao {

    List<CourseStudent> selectcourseidByStuId(int studentid);//根据学生id查询其所拥有的课程id
}
