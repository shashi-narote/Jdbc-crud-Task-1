package com.crud.jdbc_crud.dto;

import com.crud.jdbc_crud.entity.Student;
import com.crud.jdbc_crud.entity.StudentProfile;

public class RequestWrapper {

    private Student student;

    private StudentProfile profile;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }
}
