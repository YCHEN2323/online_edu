package com.online.edu.service.impl;

import com.online.edu.dao.UserDao;
import com.online.edu.pojo.User;
import com.online.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectFromId(int stu_id) {
        return userDao.selectFromId(stu_id);
    }

    @Override
    public void updateInfo(int id) {
        userDao.updateInfo(id);
    }

    @Override
    public User loginSelect(String loginname, String password) {
        return userDao.loginSelect(loginname,password);
    }

    @Override
    public User userType(String loginname, int type) {
        return userDao.userType(loginname,type);
    }



}
