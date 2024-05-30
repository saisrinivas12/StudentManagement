package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.CurricularActivitesDto;
import com.student.StudentManagement.entities.CurricularActivities;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.CurricularActivitiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurricularActivitesImpl implements CurricularActivitesService{

    @Autowired
    private CurricularActivitiesRepository curricularActivitiesRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public CurricularActivitesDto save(CurricularActivities activites) {
        CurricularActivities activity = this.curricularActivitiesRepository.save(activites);
        return this.mapper.map(activity,CurricularActivitesDto.class);
    }

    @Override
    public List<CurricularActivitesDto> getAllActivites() {
        List<CurricularActivities> activites = this.curricularActivitiesRepository.findAll();
        List<CurricularActivitesDto> activitesDtos =activites.stream().map(activity -> this.mapper.map(activity,CurricularActivitesDto.class)).collect(Collectors.toList());
        return activitesDtos;
    }

    @Override
    public CurricularActivitesDto getActivityById(Integer id) throws Exception{
        CurricularActivities activity =  this.curricularActivitiesRepository.findById(id.longValue()).orElseThrow(()-> new ResourceNotFoundException("Requested Curricular activity id not found on the server"));
        return this.mapper.map(activity,CurricularActivitesDto.class);
    }
}
