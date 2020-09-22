package com.online.edu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CourseWare {
    private int id;
    private int courseid;
    private String name;
    private String path;
    private int createrid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private int downloadmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCreaterid() {
        return createrid;
    }

    public void setCreaterid(int createrid) {
        this.createrid = createrid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getDownloadmount() {
        return downloadmount;
    }

    public void setDownloadmount(int downloadmount) {
        this.downloadmount = downloadmount;
    }

    @Override
    public String toString() {
        return "CourseWare{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", createrid=" + createrid +
                ", createtime=" + createtime +
                ", downloadmount=" + downloadmount +
                '}';
    }
}
