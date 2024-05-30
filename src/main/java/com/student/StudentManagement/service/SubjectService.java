package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.SubjectDto;
import com.student.StudentManagement.entities.Subject;

import java.util.List;

public interface SubjectService {


    SubjectDto save(Subject subject);


    List<SubjectDto>getAllSubjects();


    SubjectDto getSubjectById(Integer id) throws Exception;
}
