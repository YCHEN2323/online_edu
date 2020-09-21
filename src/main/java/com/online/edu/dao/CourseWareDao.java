package com.online.edu.dao;


import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CourseWareDao {
    @Insert("INSERT INTO course_courseware (name,path,createtime) VALUES (#{name}, #{path},#{createtime})")
    void insertFile(String name, String path, Date createtime);
}
