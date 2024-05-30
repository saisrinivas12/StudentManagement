package com.student.StudentManagement.Controller;


import com.student.StudentManagement.dto.CurricularActivitesDto;
import com.student.StudentManagement.entities.CurricularActivities;
import com.student.StudentManagement.repository.CurricularActivitiesRepository;
import com.student.StudentManagement.service.CurricularActivitesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class CurricularActivitiesController {

    @Autowired
    private CurricularActivitesService service;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/saveActivity")
    public ResponseEntity<?>saveActivity(@RequestBody CurricularActivitesDto curricularActivitesDto){
        CurricularActivities activity = this.mapper.map(curricularActivitesDto,CurricularActivities.class);
        CurricularActivitesDto result = this.service.save(activity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("/getActivites")
    public ResponseEntity<?>getAllActivities(){
        List<CurricularActivitesDto>dtos = this.service.getAllActivites();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
    }

    @GetMapping("/getActivity/{activityId}")
    public ResponseEntity<?>getActivityById(@PathVariable(name="activityId")Integer activityId) throws Exception{
        CurricularActivitesDto dto = this.service.getActivityById(activityId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }



}
