package com.online.edu.pojo;

public class CourseStudent {
    private int classid;
    private int studentid;
    private String studentname;

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "classid=" + classid +
                ", studentid=" + studentid +
                ", studentname='" + studentname + '\'' +
                '}';
    }
}
