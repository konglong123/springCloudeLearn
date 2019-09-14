package com.kong.demo1.entity;

import java.io.Serializable;

/**
 * @program: homework
 * @description:
 * @author: Mr.Kong
 * @create: 2019-05-24 10:39
 **/
public class Student implements Serializable {
    private Integer studentid;
    private String name;
    private String number;
    private String password;
    private String email;
    private String cellphone;
    private char sex;
    private String schoole;

    public Student(Integer studentid, String name, String number, String password) {
        this.studentid = studentid;
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public Student(){}

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getSchoole() {
        return schoole;
    }

    public void setSchoole(String schoole) {
        this.schoole = schoole;
    }
}
