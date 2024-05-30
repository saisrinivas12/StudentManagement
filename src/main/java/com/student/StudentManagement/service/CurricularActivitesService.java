package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.CurricularActivitesDto;
import com.student.StudentManagement.entities.CurricularActivities;

import java.util.List;

public interface CurricularActivitesService {


    CurricularActivitesDto save(CurricularActivities activites);


    List<CurricularActivitesDto> getAllActivites();

    CurricularActivitesDto getActivityById(Integer id ) throws Exception;
}
