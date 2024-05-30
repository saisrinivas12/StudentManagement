package com.student.StudentManagement.dto;

import com.student.StudentManagement.entities.Lecturer;
import com.student.StudentManagement.entities.Location;
import com.student.StudentManagement.entities.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class BusDetailsDto {
    private int busId;


    private String driverName;

    private LocationDto location;

    private long driverNo;




    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }


    public long getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(long driverNo) {
        this.driverNo = driverNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "BusDetailsDto{" +
                "busId=" + busId +
                ", driverName='" + driverName + '\'' +
                ", locationDto=" + location +
                ", driverNo=" + driverNo +
                '}';
    }
}
