package com.sss.online.pojo;

import java.sql.Timestamp;

/**
 * @author
 * @create 2019-07-30-16:18
 */
public class XZBB {
    int id;
    String empName;
    String deptName;
    String post;
    String typeName;
    String formTypeDetail;
    Timestamp createDate;
    Timestamp start;
    Timestamp end;
    String time;

    @Override
    public String toString() {
        return "XZBB{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", post='" + post + '\'' +
                ", typeName='" + typeName + '\'' +
                ", formTypeDetail='" + formTypeDetail + '\'' +
                ", createDate=" + createDate +
                ", start=" + start +
                ", end=" + end +
                ", time='" + time + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
