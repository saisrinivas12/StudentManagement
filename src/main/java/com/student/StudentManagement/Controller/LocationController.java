package com.student.StudentManagement.Controller;


import com.student.StudentManagement.dto.LocationDto;
import com.student.StudentManagement.entities.Location;
import com.student.StudentManagement.service.LocationService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/saveLocation")
    public ResponseEntity<?>saveLocation(@RequestBody LocationDto locationDto){
        Location location = this.mapper.map(locationDto,Location.class);
        LocationDto locationDto1 = this.locationService.saveLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationDto1);
    }


    @GetMapping("/getAllLocations")
    public ResponseEntity<?>getAllLocations(){
        List<LocationDto> locations = this.locationService.getAllLocations();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(locations);
    }

    @GetMapping("/getLocation/{locationId}")
    public ResponseEntity<?>getLocationById(@PathVariable(name="locationId")Integer locationId) throws Exception{
        LocationDto locationDto = this.locationService.getLocationById(locationId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(locationDto);
    }

}
