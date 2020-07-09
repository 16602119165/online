package com.sss.online.pojo;

import java.sql.Timestamp;

/**
 * @author
 * @create 2019-07-04-14:46
 */
public class XZGL {
    int id;
    int type;
    String typeName;
    String empName;
    String deptName;
    String post;
    int empId;
    Timestamp createDate;
    Timestamp start;
    Timestamp end;
    String formType;
    String leader;
    String content;//内容
    String cs;//抄送
    String time;
    String formTypeDetail;

    @Override
    public String toString() {
        return "XZGL{" +
                "id=" + id +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", post='" + post + '\'' +
                ", empId=" + empId +
                ", createDate=" + createDate +
                ", start=" + start +
                ", end=" + end +
                ", formType='" + formType + '\'' +
                ", leader='" + leader + '\'' +
                ", content='" + content + '\'' +
                ", cs='" + cs + '\'' +
                ", time=" + time +
                ", formTypeDetail='" + formTypeDetail + '\'' +
                '}';
    }

    public String getFormTypeDetail() {
        return formTypeDetail;
    }

    public void setFormTypeDetail(String formTypeDetail) {
        this.formTypeDetail = formTypeDetail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }
}
