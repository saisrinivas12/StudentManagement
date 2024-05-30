package com.student.StudentManagement.Controller;

import com.student.StudentManagement.dto.OpenElectivesDto;
import com.student.StudentManagement.entities.OpenElectives;
import com.student.StudentManagement.service.OpenElectivesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/openelectives")
public class OpenElectivesController {
    @Autowired
    private OpenElectivesService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/saveOpenElectives")
    public ResponseEntity<?>saveElective(@RequestBody OpenElectivesDto openElectivesDto){
        OpenElectives electives = this.mapper.map(openElectivesDto,OpenElectives.class);
        OpenElectivesDto openElectivesDto1 = this.service.saveOpenElectives(electives);
        return ResponseEntity.status(HttpStatus.CREATED).body(openElectivesDto1);
    }


    @GetMapping("/getAllElectives")
    public ResponseEntity<?>getAllElectives(){
        List<OpenElectivesDto> openElectivesDtos = this.service.getAllOpenElectives();;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(openElectivesDtos);
    }

    @GetMapping("/getElectives/{openElectivesId}")
    public ResponseEntity<?>getElectivesById(@PathVariable(name="openElectivesId")Integer openElectivesId) throws Exception{
       OpenElectivesDto openElectivesDto = this.service.getOpenElectivesById(openElectivesId);
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(openElectivesDto);
    }



}
