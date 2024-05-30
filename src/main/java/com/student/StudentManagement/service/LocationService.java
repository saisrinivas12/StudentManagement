package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.LocationDto;
import com.student.StudentManagement.entities.Location;

import java.util.List;

public interface LocationService {

    LocationDto saveLocation(Location location);

    List<LocationDto>getAllLocations();

    LocationDto getLocationById(Integer id);


}
