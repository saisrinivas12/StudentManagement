package com.student.StudentManagement.dto;

import com.student.StudentManagement.entities.BusDetails;
import com.student.StudentManagement.entities.Location;
import com.student.StudentManagement.entities.OpenElectives;
import com.student.StudentManagement.entities.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class LecturerDto {
    private int lecturerId;

    private String lecturerName;

    private String Department;

    private LocationDto location;

    private BusDetailsDto busDetails;

    private Set<SubjectDto> subjects = new HashSet<>();

    private OpenElectivesDto openElectives;

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public BusDetailsDto getBusDetails() {
        return busDetails;
    }

    public void setBusDetails(BusDetailsDto busDetails) {
        this.busDetails = busDetails;
    }

    public Set<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    public OpenElectivesDto getOpenElectives() {
        return openElectives;
    }

    public void setOpenElectives(OpenElectivesDto openElectives) {
        this.openElectives = openElectives;
    }}
