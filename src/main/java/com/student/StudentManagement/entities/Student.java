package com.student.StudentManagement.entities;

import javax.persistence.*;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="STUDENT")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STUDENT_ID")
    private Long studentId;

    @Column(name="STUDENT_NAME")
    private String studentName;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name="SEMESTER")
    private String Semester;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Subject> subjects = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Fees>fees = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OpenElectives>openElectives = new HashSet<>();


    @ManyToOne
    private BusDetails busDetails;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Lecturer> lecturers = new HashSet<>();

    @ManyToOne
    private Location location;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<CurricularActivities> activities = new HashSet<>();

    public Set<CurricularActivities> getActivities() {
        return activities;
    }

    public void setActivities(Set<CurricularActivities> activities) {
        this.activities = activities;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Fees> getFees() {
        return fees;
    }

    public void setFees(Set<Fees> fees) {
        this.fees = fees;
    }

    public Set<OpenElectives> getOpenElectives() {
        return openElectives;
    }

    public void setOpenElectives(Set<OpenElectives> openElectives) {
        this.openElectives = openElectives;
    }

    public BusDetails getBusDetails() {
        return busDetails;
    }

    public void setBusDetails(BusDetails busDetails) {
        this.busDetails = busDetails;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

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

    @Override
    public String toString() {
        return "Student{" +
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
