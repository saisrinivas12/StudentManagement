package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.LecturerDto;
import com.student.StudentManagement.entities.Lecturer;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.LecturerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturerServiceImpl implements LecturerService{

    @Autowired
    private LecturerRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public LecturerDto saveLecturer(Lecturer lecturer) {
        Lecturer lecturer1 = this.repository.save(lecturer);
        return this.mapper.map(lecturer1,LecturerDto.class);
    }

    @Override
    public List<LecturerDto> getAllLecturers() {
        List<Lecturer>lecturers = this.repository.findAll();
        List<LecturerDto>lecturerDtos = lecturers.stream().map(lecturer-> this.mapper.map(lecturer,LecturerDto.class)).collect(Collectors.toList());
        return lecturerDtos;
    }

    @Override
    public LecturerDto getLecturerById(Integer id) throws Exception {
        Lecturer lecturer = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requested Id not found on the server"));
        return this.mapper.map(lecturer,LecturerDto.class);
    }
}
