package com.crud.jdbc_crud.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@EntityScan
public class StudentProfile {

    private int id;

    private String address;

    private String dateOfBirth;

    private String course;

    private int studentId;

   // private Student student;

    public StudentProfile() {

    }

    public StudentProfile(int id, String address, String dateOfBirth, String course, int studentId, Student student) {
        this.id = id;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
        this.studentId = studentId;
        //this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

  /*  public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/
}
