package com.online.edu.pojo;

import java.util.Date;

public class Student {
    private int stu_id;
    private String stu_name;
    private String stu_number;
    private int stu_gender;
    private Date stu_birthdate;

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_number() {
        return stu_number;
    }

    public void setStu_number(String stu_number) {
        this.stu_number = stu_number;
    }

    public int getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(int stu_gender) {
        this.stu_gender = stu_gender;
    }

    public Date getStu_birthdate() {
        return stu_birthdate;
    }

    public void setStu_birthdate(Date stu_birthdate) {
        this.stu_birthdate = stu_birthdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_number='" + stu_number + '\'' +
                ", stu_gender=" + stu_gender +
                ", stu_birthdate=" + stu_birthdate +
                '}';
    }
}
