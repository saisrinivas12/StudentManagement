package com.student.StudentManagement.Controller;

import com.student.StudentManagement.dto.BusDetailsDto;
import com.student.StudentManagement.dto.LocationDto;
import com.student.StudentManagement.entities.BusDetails;
import com.student.StudentManagement.entities.Location;
import com.student.StudentManagement.repository.LocationRepository;
import com.student.StudentManagement.service.BusDetailsService;
import com.student.StudentManagement.service.LocationService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/busdetails")
public class BusDetailsController {
    @Autowired
    private BusDetailsService busDetailsService;

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private LocationService locationService;



    private static final Map<Integer,Location>locationMap = new HashMap<>();

    @PostMapping("/saveBusDetails/{locationId}")
    public ResponseEntity<?>saveBusDetails(@RequestBody BusDetailsDto busDetailsDto, @PathVariable(name = "locationId")Integer locationId) throws Exception{
        BusDetails busDetails = this.mapper.map(busDetailsDto,BusDetails.class);
        System.out.println("bus details "+busDetails);
        if(!locationMap.containsKey(locationId)) {
            System.out.println("locations are empty ");
            LocationDto location = this.locationService.getLocationById(locationId);
            Location locationVal = this.mapper.map(location, Location.class);
            locationMap.put(locationId,locationVal);
        }
        busDetails.setLocation(locationMap.get(locationId));
        BusDetailsDto dto = this.busDetailsService.saveBusDetails(busDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


    @GetMapping("/getAllBusDetails")
    public ResponseEntity<?> getAllBusDetails(){
        List<BusDetailsDto>dtos = this.busDetailsService.getAllBusDetails();;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
    }

    @GetMapping("/getBusDetails/{busId}")
    public ResponseEntity<?>getBusDetailsById(@PathVariable(name="busId")Integer busId) throws Exception{
         BusDetailsDto dto = this.busDetailsService.getBusDetailsById(busId);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }

}
