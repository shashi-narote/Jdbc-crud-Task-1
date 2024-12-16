package com.crud.jdbc_crud.service;

import com.crud.jdbc_crud.entity.Student;
import com.crud.jdbc_crud.entity.StudentProfile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudent() throws SQLException, IOException;

    Student getStudentById(int id) throws SQLException, IOException;

    String addStudent(Student student, StudentProfile studentProfile) throws SQLException, IOException;

    String deleteStudentById(int id) throws SQLException, IOException;

    String updateStudent(Student student, StudentProfile studentProfile) throws SQLException, IOException;
}
