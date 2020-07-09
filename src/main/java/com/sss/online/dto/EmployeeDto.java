package com.sss.online.dto;

import java.io.Serializable;

/**
 * @author
 * @create 2019-06-05-13:25
 */
public class EmployeeDto implements Serializable {
    String name;//员工姓名
    String deptName;//员工部门
    String post;//员工职位
    int empId;//员工工号
    String email;//员工邮箱
    String leader;//直属领导
    String leaderEmail;//领导邮箱

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public EmployeeDto() {
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", post='" + post + '\'' +
                ", empId=" + empId +
                ", email='" + email + '\'' +
                ", leader='" + leader + '\'' +
                ", leaderEmail='" + leaderEmail + '\'' +
                '}';
    }
}
