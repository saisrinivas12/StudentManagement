package com.student.StudentManagement.dto;

import com.student.StudentManagement.entities.Lecturer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class OpenElectivesDto {

    private int openElectiveId;

    private String openElectiveName;
    private String department;




    public int getOpenElectiveId() {
        return openElectiveId;
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

    @Override
    public String toString() {
        return "OpenElectivesDto{" +
                "openElectiveId=" + openElectiveId +
                ", openElectiveName='" + openElectiveName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
