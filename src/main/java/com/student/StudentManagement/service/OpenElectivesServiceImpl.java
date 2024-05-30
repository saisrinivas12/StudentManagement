package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.OpenElectivesDto;
import com.student.StudentManagement.entities.OpenElectives;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.OpenElectivesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class OpenElectivesServiceImpl implements OpenElectivesService{

    @Autowired
    private OpenElectivesRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public OpenElectivesDto saveOpenElectives(OpenElectives openElectives) {
        OpenElectives openElectives1 = this.repository.save(openElectives);
        return this.mapper.map(openElectives1,OpenElectivesDto.class);
    }

    @Override
    public List<OpenElectivesDto> getAllOpenElectives() {
        List<OpenElectives> openElectives = this.repository.findAll();
        List<OpenElectivesDto> openElectivesDtos = openElectives.stream().map(openElective1 -> this.mapper.map(openElective1,OpenElectivesDto.class)).collect(Collectors.toList());
        return openElectivesDtos;
    }

    @Override
    public OpenElectivesDto getOpenElectivesById(Integer id) throws Exception {
        OpenElectives openElectives = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requested Id not found on the server"));
        return this.mapper.map(openElectives,OpenElectivesDto.class);
    }
}
