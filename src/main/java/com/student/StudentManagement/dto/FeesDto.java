package com.student.StudentManagement.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class FeesDto {

    private int feesId;

    private String feesName;

    private double feesAmount;

    public double getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(double feesAmount) {
        this.feesAmount = feesAmount;
    }

    public int getFeesId() {
        return feesId;
    }

    public void setFeesId(int feesId) {
        this.feesId = feesId;
    }

    public String getFeesName() {
        return feesName;
    }

    public void setFeesName(String feesName) {
        this.feesName = feesName;
    }

}
