package com.sss.online.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author
 * @create 2019-07-29-9:52
 */
public class XZBBQueryVO {

    @NotNull@NotEmpty
    String empName;

    @NotNull@NotEmpty
    String formTypeDetail;

    @NotNull@NotEmpty
    String startTime;

    @NotNull@NotEmpty
    String endTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
