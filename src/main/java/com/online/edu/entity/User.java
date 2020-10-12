package com.online.edu.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@TableName("common_user")
public class User {
    private int id;
    private String loginname;
    private String name;
    private String password;
    private int type;

}
