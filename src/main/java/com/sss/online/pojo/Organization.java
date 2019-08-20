package com.sss.online.pojo;

/**
 * @author
 * @create 2019-07-29-16:13
 */
public class Organization {
    int id;
    String orgName;
    int orgCode;
    String empName;
    String empEmail;
    int  orgPId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(int orgCode) {
        this.orgCode = orgCode;
    }

    public int getOrgPId() {
        return orgPId;
    }

    public void setOrgPId(int orgPId) {
        this.orgPId = orgPId;
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
    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", orgPId='" + orgPId + '\'' +
                '}';
    }
}
