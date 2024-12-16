package com.crud.jdbc_crud.repository;

import com.crud.jdbc_crud.entity.Student;
import com.crud.jdbc_crud.entity.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //GET ALL STUDENTS
    public List<Student> getAllStudents(){

        //FETCHING DATA FROM STUDENT TABLE
        String getQuery="SELECT * FROM student";
        List<Student> students = jdbcTemplate.query(getQuery, new StudentRowMapper());

        for(Student s:students){
                //FETCHING DATA FROM STUDENT_PROFILE TABLE
                String getProfileQuery = "SELECT * FROM student_profile WHERE student_id = ?";
                List<StudentProfile> studentProfile = jdbcTemplate.query(getProfileQuery, new Object[]{s.getId()}, new StudentProfileMapper());
                s.setStudentProfile(studentProfile);
        }
        return students;
    }


    //GET STUDENT BY ID
    public Student getStudentById(int id){

        //FETCHING DATA FROM STUDENT
        String getStudentQuery = "SELECT * FROM student WHERE id = ?";
        Student student = jdbcTemplate.queryForObject(getStudentQuery, new Object[]{id}, new StudentRowMapper());

        String getProfileQuery = "SELECT * FROM student_profile WHERE student_id = ?";
        List<StudentProfile> studentProfile = jdbcTemplate.query(getProfileQuery, new Object[]{id}, new StudentProfileMapper());
        student.setStudentProfile(studentProfile);

        return student;
    }


    //ADD STUDENT
    public int addStudent(Student student, StudentProfile studentProfile){
        String addQuery="INSERT INTO student VALUES(?,?,?,?)";
        int count = jdbcTemplate.update(addQuery, student.getId(), student.getName(), student.getPhone(), student.getEmail());

        //FOR RETRIEVE RECENT ADDED DATA ID
        String query = "SELECT LAST_INSERT_ID()";
        int studentId = jdbcTemplate.queryForObject(query, Integer.class);

        //ADDING STUDENT PROFILE
        String addProfile = "INSERT INTO student_profile(address, date_of_birth, course, student_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(addProfile, studentProfile.getAddress(), studentProfile.getDateOfBirth(), studentProfile.getCourse(), studentId);

        return studentId;
    }


    //ADD PROFILE
    public void addStudentProfile(StudentProfile studentProfile){
        String addQuery = " INSERT INTO student_profile VALUES(?,?,?,?,?)";
        jdbcTemplate.update(addQuery, studentProfile.getStudentId(), studentProfile.getAddress(), studentProfile.getDateOfBirth(), studentProfile.getCourse(), studentProfile.getStudentId());

    }


    //DELETE STUDENT BY ID
    public int deleteStudentById(int id){
        String deleteQuery="DELETE FROM student WHERE id = ?";
        int count = jdbcTemplate.update(deleteQuery, id);

        String deleteProfile = "DELETE FROM student_profile WHERE student_id = ?";
        jdbcTemplate.update(deleteProfile, id);
        return count;
    }


    //UPDATE STUDENT
    public int updateStudent(Student student, StudentProfile studentProfile){

        //UPDATING STUDENT
        String updateQuery = " UPDATE student SET name=?, phone=?, email=? WHERE id=?";
        int count = jdbcTemplate.update(updateQuery, student.getName(), student.getPhone(), student.getEmail(), student.getId());

        //UPDATING STUDENT_PROFILE
        String updateProfile = " UPDATE student_profile SET address = ?, date_of_birth = ?, course = ? WHERE student_id = ?";
        jdbcTemplate.update(updateProfile, studentProfile.getAddress(), studentProfile.getDateOfBirth(), studentProfile.getCourse(), student.getId());
        return count;
    }



    public static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            // STUDENT MAPPING
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setPhone(rs.getInt("phone"));
            student.setEmail(rs.getString("email"));
            return student;
        }
    }


    public class StudentProfileMapper implements RowMapper<StudentProfile> {

        @Override
        public StudentProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
            //STUDENT PROFILE MAPPING
            StudentProfile studentProfile = new StudentProfile();
            studentProfile.setId(rs.getInt("id"));
            studentProfile.setDateOfBirth(rs.getString("date_of_birth"));
            studentProfile.setCourse(rs.getString("course"));
            studentProfile.setAddress(rs.getString("address"));
            studentProfile.setStudentId(rs.getInt("student_id"));
            return studentProfile;
        }
    }
}
