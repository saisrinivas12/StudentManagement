package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.BusDetailsDto;
import com.student.StudentManagement.entities.BusDetails;

import java.util.List;

public interface BusDetailsService {

    BusDetailsDto saveBusDetails(BusDetails busDetails);

    List<BusDetailsDto>getAllBusDetails();

    BusDetailsDto getBusDetailsById(Integer id) throws Exception;
}
