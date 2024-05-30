package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.StudentDto;
import com.student.StudentManagement.entities.Student;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(Student student);

    List<StudentDto>getAllStudents();

    StudentDto getStudentById(Integer id);
}
