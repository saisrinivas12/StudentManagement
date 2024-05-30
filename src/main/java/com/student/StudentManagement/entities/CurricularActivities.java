package com.student.StudentManagement.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRICULAR_ACTIVITES")
public class CurricularActivities {

    @Id
    @Column(name="ACTIVITY_ID")
    private long activityId;

    @Column(name="ACTIVITY_NAME")
    private String activityName;

    @Column(name="HOSTED_BY")
    private String hostedBy;

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getHostedBy() {
        return hostedBy;
    }

    public void setHostedBy(String hostedBy) {
        this.hostedBy = hostedBy;
    }
}
