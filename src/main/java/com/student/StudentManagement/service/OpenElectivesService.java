package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.OpenElectivesDto;
import com.student.StudentManagement.entities.OpenElectives;

import java.util.List;

public interface OpenElectivesService {

    OpenElectivesDto saveOpenElectives(OpenElectives openElectives);

    List<OpenElectivesDto>getAllOpenElectives();


    OpenElectivesDto getOpenElectivesById(Integer id) throws Exception;
}
