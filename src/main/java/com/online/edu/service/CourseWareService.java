package com.online.edu.service;

import com.online.edu.pojo.CourseWare;

import java.util.Date;
import java.util.List;

public interface CourseWareService {

    void insertFile(String name, String path, Date createtime);
    List<CourseWare> SelcetList();
}
