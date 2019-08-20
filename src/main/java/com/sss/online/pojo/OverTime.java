package com.sss.online.pojo;

import java.sql.Timestamp;

/**
 * @author
 * @create 2019-06-04-15:56 加班
 */
public class OverTime {
    int id;//主键
    int empId;//员工id
    String empName;//员工姓名
    String empEmail;//员工邮箱
    String workStart;//开始时间
    String workEnd;//结束时间
    Double workTime;//加班时长
    String workContent;//加班事项
    String leader;//审批人
    String leaderEmail;//审批人邮箱
    String type;//审批状态
    String otherEmail; //抄送其他人

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        this.workEnd = workEnd;
    }

    public Double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Double workTime) {
        this.workTime = workTime;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderEmail() {
        return leaderEmail;
    }

    public void setLeaderEmail(String leaderEmail) {
        this.leaderEmail = leaderEmail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOtherEmail() {
        return otherEmail;
    }

    public void setOtherEmail(String otherEmail) {
        this.otherEmail = otherEmail;
    }

    @Override
    public String toString() {
        return "OverTime{" +
                "id=" + id +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", workStart='" + workStart + '\'' +
                ", workEnd='" + workEnd + '\'' +
                ", wordTime=" + workTime +
                ", workContent='" + workContent + '\'' +
                ", leader='" + leader + '\'' +
                ", leadEmail='" + leaderEmail + '\'' +
                ", type='" + type + '\'' +
                ", otherEmail='" + otherEmail + '\'' +
                '}';
    }
}
