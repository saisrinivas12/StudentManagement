package com.student.StudentManagement.dto;

import javax.persistence.Column;

public class SubjectDto {
    private int subjectId;

    private String subjectName;

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

    @Override
    public String toString() {
        return "SubjectDto{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
