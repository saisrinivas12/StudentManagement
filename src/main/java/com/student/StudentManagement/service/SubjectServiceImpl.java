package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.SubjectDto;
import com.student.StudentManagement.entities.Subject;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements  SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public SubjectDto save(Subject subject) {
        Subject savedSubject = this.subjectRepository.save(subject);
        return this.mapper.map(savedSubject,SubjectDto.class);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = this.subjectRepository.findAll();
        List<SubjectDto> dtos = subjects.stream().map(subject -> this.mapper.map(subject, SubjectDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public SubjectDto getSubjectById(Integer id) throws Exception {
        Subject subject = this.subjectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requested id not found on the server"));
        return this.mapper.map(subject, SubjectDto.class);
    }
}
