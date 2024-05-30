package com.student.StudentManagement.entities;


import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="LOCATION")
public class Location {

    @Id
    @Column(name="LOCATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @Column(name="LOCATION_NAME")
    private String locationName;


    @Column(name="DISTANCE_TO_COLLEGE")
    private long distanceToCollege;

    @OneToMany(mappedBy = "location")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "location")
    private Set<Lecturer> lecturers = new HashSet<>();

    @OneToMany(mappedBy = "location")
    private Set<BusDetails> busDetails = new HashSet<>();

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public Set<BusDetails> getBusDetails() {
        return busDetails;
    }

    public void setBusDetails(Set<BusDetails> busDetails) {
        this.busDetails = busDetails;
    }
}
