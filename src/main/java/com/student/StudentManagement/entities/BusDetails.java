package com.student.StudentManagement.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="BUS_DETAILS")
public class BusDetails {

    @Id
    @Column(name="BUS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;


    @Column(name="DRIVER_NAME")
    private String driverName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Location location;

    @Column(name="DRIVER_NO")
    private long driverNo;

    @OneToMany(mappedBy = "busDetails")
    private Set<Student>students = new HashSet<>();

    @OneToMany(mappedBy = "busDetails")
    private Set<Lecturer> lecturers = new HashSet<>();


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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
}
