package com.online.edu.dao;

import com.online.edu.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    @Select("SELECT * FROM common_user where id=#{id}")
    Student selectFromId(int stu_id);//根据id查询单个学生信息

    @Insert("INSERT INTO student (name,password) VALUE" +
            "(#{name},#{password})")
    void insertInfo(Student student);//注册插入信息，可删除；

    @Update("UPDATE common_user SET name=#{name}, password=#{password}, WHERE id=#{id}")
    void updateInfo(int id);

    @Select("SELECT * FROM common_user WHERE loginname=#{loginname} or password =#{password}")
    Student loginSelect(String loginname, String password);
}