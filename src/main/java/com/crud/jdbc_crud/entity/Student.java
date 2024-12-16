package com.crud.jdbc_crud.entity;

import java.util.List;

public class Student {

    private int id;

    private String name;

    private int phone;

    private String email;

    private List<StudentProfile> studentProfile;

    public Student(){

    }

    public Student(int id, String name, int phone, String email, List<StudentProfile> studentProfile) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.studentProfile = studentProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ONE-TO-MANY RELATIONSHIP
    public List<StudentProfile> getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(List<StudentProfile> studentProfile) {
        this.studentProfile = studentProfile;
    }
}
