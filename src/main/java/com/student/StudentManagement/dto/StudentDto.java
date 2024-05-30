package com.student.StudentManagement.dto;

import com.student.StudentManagement.entities.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class StudentDto {
    private long studentId;

    private String studentName;

    private String department;

    private String Semester;


    private Set<SubjectDto> subjects = new HashSet<>();



    private Set<FeesDto>fees = new HashSet<>();



    private Set<OpenElectivesDto>openElectives = new HashSet<>();


    private BusDetailsDto busDetails;

    private Set<LecturerDto> lecturers = new HashSet<>();

    private LocationDto location;

    private Set<CurricularActivitesDto> activities = new HashSet<>();

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public Set<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    public Set<FeesDto> getFees() {
        return fees;
    }

    public void setFees(Set<FeesDto> fees) {
        this.fees = fees;
    }

    public Set<OpenElectivesDto> getOpenElectives() {
        return openElectives;
    }

    public void setOpenElectives(Set<OpenElectivesDto> openElectives) {
        this.openElectives = openElectives;
    }

    public BusDetailsDto getBusDetails() {
        return busDetails;
    }

    public void setBusDetails(BusDetailsDto busDetails) {
        this.busDetails = busDetails;
    }

    public Set<LecturerDto> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<LecturerDto> lecturers) {
        this.lecturers = lecturers;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public Set<CurricularActivitesDto> getActivities() {
        return activities;
    }

    public void setActivities(Set<CurricularActivitesDto> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", department='" + department + '\'' +
                ", Semester='" + Semester + '\'' +
                ", subjects=" + subjects +
                ", fees=" + fees +
                ", openElectives=" + openElectives +
                ", busDetails=" + busDetails +
                ", lecturers=" + lecturers +
                ", location=" + location +
                ", activities=" + activities +
                '}';
    }
}