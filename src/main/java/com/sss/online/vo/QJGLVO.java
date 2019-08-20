package com.sss.online.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author
 * @create 2019-07-04-9:55
 */
//对应请假表单
public class QJGLVO {
    @NotNull@NotEmpty
    String empName;
    @NotNull@NotEmpty
    String deptName;
    @NotNull@NotEmpty
    String post;
    @NotNull@NotEmpty
    String empId;
    @NotNull@NotEmpty
    String qjlx;
    @NotNull@NotEmpty
    String start;//请假开始时间
    @NotNull@NotEmpty
    String end;//请假结束时间
    @NotNull@NotEmpty
    String qjsy;//请假事由
    @NotNull@NotEmpty
    String leader;

    String cs;//抄送
    @NotEmpty@NotNull
    String time;//请假时间小计
    @NotNull@NotEmpty
    String formTypeDetail;

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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getQjlx() {
        return qjlx;
    }

    public void setQjlx(String qjlx) {
        this.qjlx = qjlx;
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

    public String getQjsy() {
        return qjsy;
    }

    public void setQjsy(String qjsy) {
        this.qjsy = qjsy;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    @Override
    public String toString() {
        return "QJGLVO{" +
                "empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", post='" + post + '\'' +
                ", empId='" + empId + '\'' +
                ", qjlx='" + qjlx + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", qjsy='" + qjsy + '\'' +
                ", leader='" + leader + '\'' +
                ", cs='" + cs + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
