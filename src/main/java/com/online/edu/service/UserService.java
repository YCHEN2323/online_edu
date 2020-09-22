package com.online.edu.service;

import com.online.edu.pojo.User;

public interface UserService {
    User selectFromId(int stu_id);
    void updateInfo(int id);
    User loginSelect(String loginname, String password);
    User userType(String loginname,int type);
}
