package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.StudentDto;
import com.student.StudentManagement.entities.Lecturer;
import com.student.StudentManagement.entities.Student;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto saveStudent(Student student) {
        Student savedStudent = this.studentRepository.save(student);
        return this.modelMapper.map(savedStudent,StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = this.studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(student -> this.modelMapper.map(student,StudentDto.class)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student = this.studentRepository.findById(id.longValue()).orElseThrow(()-> new ResourceNotFoundException("Requested Id not found on the server"));
        return this.modelMapper.map(student,StudentDto.class);
    }
}
