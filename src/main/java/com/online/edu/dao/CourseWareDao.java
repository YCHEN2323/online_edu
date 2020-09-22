package com.online.edu.dao;


import com.online.edu.pojo.CourseWare;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseWareDao {
    @Insert("INSERT INTO course_courseware (name,path,createtime) VALUES (#{name}, #{path},#{createtime})")
    void insertFile(String name, String path, Date createtime);

    @Select("SELECT * FROM course_courseware")
    List<CourseWare> SelcetList();
}
