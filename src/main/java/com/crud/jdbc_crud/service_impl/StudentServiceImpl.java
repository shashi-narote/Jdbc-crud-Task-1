package com.crud.jdbc_crud.service_impl;

import com.crud.jdbc_crud.repository.StudentRepository;
import com.crud.jdbc_crud.entity.Student;
import com.crud.jdbc_crud.entity.StudentProfile;
import com.crud.jdbc_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() throws SQLException, IOException {
        List<Student> students;
        students = studentRepository.getAllStudents();
        return students;
    }


    @Override
    public Student getStudentById(int id) throws SQLException, IOException{
        return studentRepository.getStudentById(id);
    }


    @Override
    public String addStudent(Student student, StudentProfile studentProfile) throws SQLException, IOException {
       int count = studentRepository.addStudent(student, studentProfile);
        if(count>0){
            return "Student Id : " +count + " added successfully!";
        }
        return "Student not added!";
    }


    @Override
    public String deleteStudentById(int id) throws SQLException, IOException {
       int count = studentRepository.deleteStudentById(id);
        if (count>0){
            return "Student deleted successfully!";
        }
        return "User not deleted!";
    }


    @Override
    public String updateStudent(Student student, StudentProfile studentProfile) throws SQLException, IOException {
        int count = studentRepository.updateStudent(student, studentProfile);
        if (count>0){
            return count + " Student updated successfully!";
        }
        return "Student not updated!";
    }
}
