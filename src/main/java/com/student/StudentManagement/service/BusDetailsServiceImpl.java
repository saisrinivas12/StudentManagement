package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.BusDetailsDto;
import com.student.StudentManagement.entities.BusDetails;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.BusDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusDetailsServiceImpl implements BusDetailsService{

    @Autowired
    private BusDetailsRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public BusDetailsDto saveBusDetails(BusDetails busDetails) {
        BusDetails details = this.repository.save(busDetails);
        BusDetailsDto detailsDto = this.mapper.map(details,BusDetailsDto.class);
        return detailsDto;
    }

    @Override
    public List<BusDetailsDto> getAllBusDetails() {
        List<BusDetails> busDetails = this.repository.findAll();
        List<BusDetailsDto> dtos = busDetails.stream().map(detail -> this.mapper.map(detail,BusDetailsDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public BusDetailsDto getBusDetailsById(Integer id) throws Exception {
        BusDetails details = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requested id not found on the server"));
        return this.mapper.map(details,BusDetailsDto.class);
    }
}
