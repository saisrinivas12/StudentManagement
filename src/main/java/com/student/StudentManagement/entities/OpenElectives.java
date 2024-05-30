package com.student.StudentManagement.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="OPEN_ELECTIVES")
public class OpenElectives {


    @Id
    @Column(name="OPEN_ELECTIVE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int openElectiveId;

    @Column(name="OPEN_ELECTIVE_NAME")
    private String openElectiveName;

    @Column(name="DEPARTMENT")
    private String department;


    @OneToMany(mappedBy = "openElectives")
    private Set<Lecturer> lecturers = new HashSet<>();

    @ManyToMany(mappedBy = "openElectives")
    private Set<Student> students = new HashSet<>();

    public int getOpenElectiveId() {
        return openElectiveId;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setOpenElectiveId(int openElectiveId) {
        this.openElectiveId = openElectiveId;
    }

    public String getOpenElectiveName() {
        return openElectiveName;
    }

    public void setOpenElectiveName(String openElectiveName) {
        this.openElectiveName = openElectiveName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }
}
