package com.online.edu.service;

import com.online.edu.pojo.Student;

public interface StudentService {
    Student selectFromId(int stu_id);
    void insertInfo(Student student);
}
