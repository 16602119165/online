package com.sss.online.vo;

import java.sql.Timestamp;

/**
 * @author
 * @create 2019-07-29-9:35
 */

public class XZBBVO {
    String id;
    String empName;
    String deptName;
    String post;
    String typeName;
    String formTypeDetail;
    String createDate;
    String start;
    String end;
    String time;

    @Override
    public String toString() {
        return "XZBBVO{" +
                "id='" + id + '\'' +
                ", empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", post='" + post + '\'' +
                ", typeName='" + typeName + '\'' +
                ", formTypeDetail='" + formTypeDetail + '\'' +
                ", createDate='" + createDate + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFormTypeDetail() {
        return formTypeDetail;
    }

    public void setFormTypeDetail(String formTypeDetail) {
        this.formTypeDetail = formTypeDetail;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public XZBBVO(String id, String empName, String deptName, String post, String typeName, String formTypeDetail, String createDate, String start, String end, String time) {
        this.id = id;
        this.empName = empName;
        this.deptName = deptName;
        this.post = post;
        this.typeName = typeName;
        this.formTypeDetail = formTypeDetail;
        this.createDate = createDate;
        this.start = start;
        this.end = end;
        this.time = time;
    }

    public XZBBVO() {
    }
}


