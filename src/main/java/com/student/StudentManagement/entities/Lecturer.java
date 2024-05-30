package com.student.StudentManagement.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="LECTURER")
public class Lecturer {

    @Id
    @Column(name="LECTURER_ID")
    private int lecturerId;

    @Column(name="LECTURER_NAME")
    private String lecturerName;

    @Column(name="DEPARTMENT")
    private String Department;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private BusDetails busDetails;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Subject> subjects = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private OpenElectives openElectives;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BusDetails getBusDetails() {
        return busDetails;
    }

    public void setBusDetails(BusDetails busDetails) {
        this.busDetails = busDetails;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public OpenElectives getOpenElectives() {
        return openElectives;
    }

    public void setOpenElectives(OpenElectives openElectives) {
        this.openElectives = openElectives;
    }
}
