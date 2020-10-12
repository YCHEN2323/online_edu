package com.online.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private int number;
    private String name;
    private String password;
    private int gender;
    private Date birthdate;
    private String phone;
    private int college_id;
    private int major_id;
}
