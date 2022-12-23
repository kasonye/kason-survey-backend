package com.asl.intern.survey.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "record")
public class Records implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;
    @Column(name = "user_name",length = 20,nullable = false)
    private String userName;
    @Column(name = "user_email",length = 16,nullable = false,unique = true)
    private String userEmail;
    @Column(name = "user_phone",length = 11,nullable = false)
    private String userPhone;
    @Column(name = "record_data",length = 10000,nullable = false)
    private String recordData;
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRecordData() {
        return recordData;
    }

    public void setRecordData(String recordData) {
        this.recordData = recordData;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", recordData='" + recordData + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
