package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.LecturerDto;
import com.student.StudentManagement.entities.Lecturer;

import java.util.List;

public interface LecturerService {
    LecturerDto saveLecturer(Lecturer lecturer);

    List<LecturerDto>getAllLecturers();

    LecturerDto getLecturerById(Integer id) throws Exception;
}
