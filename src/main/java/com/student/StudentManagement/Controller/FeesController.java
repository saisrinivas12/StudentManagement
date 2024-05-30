package com.student.StudentManagement.Controller;


import com.student.StudentManagement.dto.FeesDto;
import com.student.StudentManagement.entities.Fees;
import com.student.StudentManagement.service.FeesService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeesController {
    @Autowired
    private FeesService feesService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/saveFees")
    public ResponseEntity<?>saveFees(@RequestBody FeesDto feesDto){
        Fees fees = this.mapper.map(feesDto,Fees.class);
        FeesDto updated = this.feesService.save(fees);
        return ResponseEntity.status(HttpStatus.CREATED).body(updated);
    }

    @GetMapping("/getAllFees")
    public ResponseEntity<?>getAllFees(){
        List<FeesDto> feesDtos = this.feesService.getAllFees();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(feesDtos);
    }

    @GetMapping("/getFees/{feesId}")
    public ResponseEntity<?>getFeesById(@PathVariable(name="feesId") Integer feesId) throws Exception{
        FeesDto feesDto = this.feesService.getFeesById(feesId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(feesDto);

    }

}
