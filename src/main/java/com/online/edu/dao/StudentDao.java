package com.online.edu.dao;

import com.online.edu.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    @Select("SELECT * FROM student where stu_id=#{stu_id}")
    Student selectFromId(int stu_id);//根据id查询单个学生信息
    @Insert("INSERT INTO student (stu_name,stu_number,stu_gender) VALUE" +
            "(#{stu_name},#{stu_number},#{stu_gender})")
    void insertInfo(Student student);//插入学生数据

}
