package com.online.edu.dao;


import com.online.edu.pojo.CourseClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseClassDao {


    @Select("selcet classname from course_class where courseid")
    List<CourseClass> selectCourse(int courseid);//根据课程id查询班级

    @Insert("insert into course_class(classname,teacherid,courseid,coursename)\n" +
            "  value (#{classname},#{teacherid},#{courseid},#{coursename})")
    int addCourse(CourseClass courseClass);//添加班级课程信息

    @Update(" update course_class set classname=#{classname},teacherid=#{teacherid},courseid=#{courseid},coursename=#{coursename}\n" +
            "        where id=#{id}")
    int updateCourse(CourseClass courseClass);//更新课程信息

    @Delete("delete from course_class where id=#{id}")
    int deleteCourse(int id);//删除课程信息

    @Select("select coursename  from course_class where teacherid=#{teacherid}")
    List<CourseClass> selectCourseByThrId(int teacherid);//根据教师id查询其所有课程

}
