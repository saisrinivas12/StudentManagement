package com.student.StudentManagement.dto;

import com.student.StudentManagement.entities.BusDetails;
import com.student.StudentManagement.entities.Lecturer;
import com.student.StudentManagement.entities.Student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class LocationDto {

    private int locationId;

    private String locationName;


    private long distanceToCollege;






    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public long getDistanceToCollege() {
        return distanceToCollege;
    }

    public void setDistanceToCollege(long distanceToCollege) {
        this.distanceToCollege = distanceToCollege;
    }



    @Override
    public String toString() {
        return "LocationDto{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", distanceToCollege=" + distanceToCollege +
                ", busDetails=" +  +
                '}';
    }
}
