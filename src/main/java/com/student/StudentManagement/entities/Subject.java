package com.student.StudentManagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class Subject {

    @Id
    @Column(name="SUBJECT_ID")
    private int subjectId;

    @Column(name="SUBJECT_NAME")
    private String subjectName;

    @Column(name="DEPARTMENT")
    private String department;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
