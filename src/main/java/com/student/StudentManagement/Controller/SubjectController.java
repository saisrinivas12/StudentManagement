package com.student.StudentManagement.Controller;

import com.student.StudentManagement.dto.SubjectDto;
import com.student.StudentManagement.entities.Subject;
import com.student.StudentManagement.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @Autowired
    private ModelMapper mapper;


    @PostMapping("/saveSubject")
    public ResponseEntity<?>saveSubject(@RequestBody SubjectDto subjectDto){
        Subject subject = this.mapper.map(subjectDto,Subject.class);
        SubjectDto savedSubject = this.subjectService.save(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubject);
    }

    @GetMapping("/getAllSubjects")
    public ResponseEntity<?>getAllSubjects(){
        List<SubjectDto> subjects = this.subjectService.getAllSubjects();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subjects);
    }
    @GetMapping("getSubject/{subjectId}")
    public ResponseEntity<?>getSubjectById(@PathVariable(name="subjectId")Integer subjectId) throws Exception{
        SubjectDto subject = this.subjectService.getSubjectById(subjectId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subject);
    }



}
