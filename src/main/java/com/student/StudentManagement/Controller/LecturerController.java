package com.student.StudentManagement.Controller;

import com.student.StudentManagement.dto.*;
import com.student.StudentManagement.entities.*;
import com.student.StudentManagement.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lecturers")
public class LecturerController
{
    @Autowired
    private LecturerService service;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LocationService locationService;
    @Autowired
    private BusDetailsService busDetailsService;

    @Autowired
    private OpenElectivesService openElectivesService;

    @Autowired
    private SubjectService subjectService;


    private static Map<Integer, Location> locationMap = new HashMap<>();

    private static Map<Integer, BusDetails>busDetailsMap = new HashMap<>();

    private static Map<Integer, OpenElectives>openElectivesMap = new HashMap<>();

    @Autowired
    private EntityManager entityManager;


@PostMapping("/saveLecturer/{locationId}/{busId}/{openElectivesId}/{subjectId}")
    public ResponseEntity<?>saveLecturer(@RequestBody LecturerDto lecturerDto, @PathVariable(name="locationId")Integer locationId,
                                         @PathVariable(name="busId")Integer busId,@PathVariable(name="openElectivesId")Integer openElectivesId
,@PathVariable(name="subjectId")Integer subjectId) throws Exception{
    System.out.println("locationMap "+locationMap+ "busdetailsMap "+busDetailsMap+ "openelectivesmap "+openElectivesMap);
    LocationDto locationDto = this.locationService.getLocationById(locationId);
    System.out.println("location dto is "+locationDto);
    BusDetailsDto busDetailsDto = this.busDetailsService.getBusDetailsById(busId);
    System.out.println("Bus dto is "+busDetailsDto);
    OpenElectivesDto openElectivesDto = this.openElectivesService.getOpenElectivesById(openElectivesId);
    System.out.println("open electives dto is "+openElectivesDto);

    SubjectDto subjectDto = this.subjectService.getSubjectById(subjectId);
    System.out.println("subject dto is "+subjectDto);
    lecturerDto.getSubjects().add(subjectDto);
   lecturerDto.setBusDetails(busDetailsDto);
   lecturerDto.setLocation(locationDto);
    lecturerDto.setOpenElectives(openElectivesDto);
    Lecturer lecturer = this.mapper.map(lecturerDto,Lecturer.class);
    LecturerDto savedLecturer = this.service.saveLecturer(lecturer);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedLecturer);

        }


    @GetMapping("/getAllLecturers")
    public ResponseEntity<?>getAllLecturers(){
        List<LecturerDto> lecturerDtos = this.service.getAllLecturers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lecturerDtos);
    }

    @GetMapping("/getLecturers/{lecturerId}")
    public ResponseEntity<?>getLecturerById(@PathVariable(name="lecturerId")Integer lecturerId) throws Exception{
       LecturerDto lecturerDto = this.service.getLecturerById(lecturerId);
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(lecturerDto);
    }

}
