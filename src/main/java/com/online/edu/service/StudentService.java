package com.online.edu.service;

import com.online.edu.pojo.Student;

public interface StudentService {
    Student selectFromId(int stu_id);
    void updateInfo(int id);
    Student loginSelect(String loginname, String password);
}
