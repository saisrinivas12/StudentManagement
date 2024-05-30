package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.FeesDto;
import com.student.StudentManagement.entities.Fees;
import com.student.StudentManagement.exceptions.ResourceNotFoundException;
import com.student.StudentManagement.repository.FeesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeesServiceImpl implements FeesService{


    @Autowired
    private FeesRepository feesRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public FeesDto save(Fees fees) {
        Fees updatedFees = this.feesRepository.save(fees);
        return this.mapper.map(updatedFees, FeesDto.class);
    }

    @Override
    public List<FeesDto> getAllFees() {
        List<Fees> allFees = this.feesRepository.findAll();
        List<FeesDto>updatedFees = allFees.stream().map(fee -> this.mapper.map(fee, FeesDto.class)).collect(Collectors.toList());
        return updatedFees;
    }

    @Override
    public FeesDto getFeesById(Integer id) throws Exception{
        Fees fees = this.feesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Fees Id not found on the server"));
        return this.mapper.map(fees, FeesDto.class);
    }
}


