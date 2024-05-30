package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.LocationDto;
import com.student.StudentManagement.entities.Location;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public LocationDto saveLocation(Location location) {
      Location savedLocation = this.locationRepository.save(location);
      return this.mapper.map(savedLocation,LocationDto.class);
    }

    @Override
    public List<LocationDto> getAllLocations() {
     List<Location> locations = this.locationRepository.findAll();
     List<LocationDto>dtos = locations.stream().map(location -> this.mapper.map(location,LocationDto.class)).collect(Collectors.toList());
     return dtos;
    }

    @Override
    public LocationDto getLocationById(Integer id) {
        Location location = this.locationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requested id not found on the server"));
        System.out.println("bus details "+location.getBusDetails());
        return this.mapper.map(location,LocationDto.class);
    }


}
