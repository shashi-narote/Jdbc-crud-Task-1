package com.crud.jdbc_crud.controller;

import com.crud.jdbc_crud.dto.RequestWrapper;
import com.crud.jdbc_crud.entity.Student;
import com.crud.jdbc_crud.entity.StudentProfile;
import com.crud.jdbc_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private StudentService studentService;


    //GET ALL STUDENTS
    @GetMapping("/students")
    public List<Student> getStudents(){
        try {
            return this.studentService.getAllStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //GET STUDENT BY ID
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable String studentId){
        try {
            return this.studentService.getStudentById(Integer.parseInt(studentId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //ADD STUDENT
    @PostMapping("/add_student")
    public String addStudent(@RequestBody RequestWrapper requestWrapper){
        try {
            return this.studentService.addStudent(requestWrapper.getStudent(), requestWrapper.getProfile());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //DELETE STUDENT BY ID
    @DeleteMapping("/student/{studentId}")
    public String deleteStudentById(@PathVariable String studentId){
        try {
            return studentService.deleteStudentById(Integer.parseInt(studentId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //UPDATE STUDENT
    @PutMapping("/update_student")
    public String updateStudent(@RequestBody RequestWrapper requestWrapper){
        try {
            return studentService.updateStudent(requestWrapper.getStudent(), requestWrapper.getProfile());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
