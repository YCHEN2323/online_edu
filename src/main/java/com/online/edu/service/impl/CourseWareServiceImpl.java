package com.online.edu.service.impl;


import com.online.edu.dao.CourseWareDao;
import com.online.edu.service.CourseWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CourseWareServiceImpl implements CourseWareService {
    @Autowired
    public CourseWareDao courseWareDao;

    @Override
    public void insertFile(String name, String path,Date createtime) {
        courseWareDao.insertFile(name,path,createtime);
    }

}
