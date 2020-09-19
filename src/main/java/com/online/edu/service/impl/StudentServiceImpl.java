package com.online.edu.service.impl;

import com.online.edu.dao.StudentDao;
import com.online.edu.pojo.Student;
import com.online.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student selectFromId(int stu_id) {
        return studentDao.selectFromId(stu_id);
    }

    @Override
    public void insertInfo(Student student) {
        studentDao.insertInfo(student);
    }
}
