package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.FeesDto;
import com.student.StudentManagement.entities.Fees;

import java.util.List;

public interface FeesService {

    FeesDto save(Fees fees);

    List<FeesDto>getAllFees();


    FeesDto getFeesById(Integer id ) throws  Exception;

}
