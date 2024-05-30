package com.student.StudentManagement.Controller;

import com.student.StudentManagement.dto.*;
import com.student.StudentManagement.entities.*;
import com.student.StudentManagement.exceptions.DetailsMisMatchException;
import com.student.StudentManagement.service.*;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
@Transactional
public class StudentController {

    @Autowired

    private StudentService studentService;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FeesService feesService;
    @Autowired
    private OpenElectivesService openElectivesService;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CurricularActivitesService activitesService;
    @Autowired
    private BusDetailsService busDetailsService;
    @Autowired
    private SubjectService subjectService;


    @PostMapping("/saveStudent/{subjectId}/{feesId}/{openElectivesId}/{lecturerId}/{locationId}/{activitiesId}/{busId}")
    public ResponseEntity<?>saveStudent(@RequestBody StudentDto studentDto
    ,@PathVariable(name = "subjectId")Integer subjectId,@PathVariable(name="feesId")Integer feesId,
                                        @PathVariable(name="openElectivesId")Integer openElectivesId,
                                        @PathVariable(name="lecturerId")Integer lecturerId,
                                        @PathVariable(name="locationId")Integer locationId,
                                        @PathVariable(name="activitiesId")long activitiesId,
                                        @PathVariable(name="busId")Integer busId) throws Exception{

        System.out.println("student received is "+studentDto);
        boolean ifTaughtByLecturer = false;
        SubjectDto subjectDto = this.subjectService.getSubjectById(subjectId);
       LecturerDto lecturerDto = this.lecturerService.getLecturerById(lecturerId);
        // check whether this lecturer teaches that particular openelective or else throw exception
        if(lecturerDto.getOpenElectives().getOpenElectiveId() != openElectivesId){
            throw new DetailsMisMatchException("provided OpenElectives Id doesnt match with lecturerId or lecturer doesnt teach this open elective");
        }
        Set<SubjectDto> subjectDtos = lecturerDto.getSubjects();
        //atleast one subject has to be taught by this lecturer
        for(SubjectDto subjectDto1 : subjectDtos){
            if(subjectDto1.getSubjectId() == subjectDto.getSubjectId()){
                ifTaughtByLecturer = true;
                break;
            }
        }
        if(!ifTaughtByLecturer){
            throw new DetailsMisMatchException("provided Subject will not be taught by this lecturer. please check and try again!!");
        }
        LocationDto locationDto = this.locationService.getLocationById(locationId);

        FeesDto feesDto = this.feesService.getFeesById(feesId);
       OpenElectivesDto openElectivesDto = this.openElectivesService.getOpenElectivesById(openElectivesId);
       CurricularActivitesDto curricularActivitesDto = this.activitesService.getActivityById((int)activitiesId);
       BusDetailsDto busDetailsDto = this.busDetailsService.getBusDetailsById(busId);
       //check if this bus is allocated to that particular location if not throw exception
        if(busDetailsDto.getLocation().getLocationId() != locationId){
            throw new DetailsMisMatchException("provided Bus was not allocated to the location Id which you have provided. so please check and try again  !!");
        }
        try {
            studentDto.getActivities().add(curricularActivitesDto);
            studentDto.getOpenElectives().add(openElectivesDto);
            studentDto.getFees().add(feesDto);
            studentDto.setLocation(locationDto);
            studentDto.getLecturers().add(lecturerDto);
            studentDto.setBusDetails(busDetailsDto);
            studentDto.getSubjects().add(subjectDto);
        }
        catch(Exception e){
            System.out.println("exception is "+e.getMessage());
        }
       Student actualStudent = this.mapper.map(studentDto,Student.class);
        System.out.println("actual student in controller "+actualStudent);
       StudentDto savedStudent = this.studentService.saveStudent(actualStudent);
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedStudent);



    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?>getAllStudents(){
        List<StudentDto> studentDtos = this.studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentDtos);
    }

    @GetMapping("/getStudentById/{studentId}")
    public ResponseEntity<?>getStudentById(@PathVariable(name="studentId")Integer studentId){
        StudentDto studentDto = this.studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentDto);
    }
}
