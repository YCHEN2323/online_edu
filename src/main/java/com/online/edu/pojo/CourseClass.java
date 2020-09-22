package com.online.edu.pojo;

public class CourseClass {

    private int id;
    private String classname;
    private int teacherid;
    private int courseid;
    private String coursename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return "Course_class{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", teacherid=" + teacherid +
                ", courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
