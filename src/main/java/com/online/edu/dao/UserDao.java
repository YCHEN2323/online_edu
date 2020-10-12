package com.online.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.online.edu.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
}
