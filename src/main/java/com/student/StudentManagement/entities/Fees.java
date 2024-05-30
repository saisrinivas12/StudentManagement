package com.student.StudentManagement.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FEES")
public class Fees {

    @Id
    @Column(name="FEES_ID")
    private int feesId;

    @Column(name="FEES_NAME")
    private String feesName;

    @Column(name="FEES_AMOUNT")
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
