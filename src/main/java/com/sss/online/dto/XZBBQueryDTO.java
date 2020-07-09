package com.sss.online.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author
 * @create 2019-07-30-13:28
 */
public class XZBBQueryDTO {

    String empName;
    String formTypeDetail;
    Timestamp startTime;
    Timestamp endTime;

    public XZBBQueryDTO() {
    }

    public XZBBQueryDTO(String empName, String formTypeDetail, Timestamp startTime, Timestamp endTime) {
        this.empName = empName;
        this.formTypeDetail = formTypeDetail;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getFormTypeDetail() {
        return formTypeDetail;
    }

    public void setFormTypeDetail(String formTypeDetail) {
        this.formTypeDetail = formTypeDetail;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "XZBBQueryDTO{" +
                "empName='" + empName + '\'' +
                ", formTypeDetail='" + formTypeDetail + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
