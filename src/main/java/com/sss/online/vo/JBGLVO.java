package com.sss.online.vo;

/**
 * @author
 * @create 2019-06-05-9:56
 */
public class JBGLVO {
    String name;//姓名
    String workStart;
    String workEnd;
    String workTime;//总计时间
    String workContent;
    String leader;
    String otherEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
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

    public String getOtherEmail() {
        return otherEmail;
    }

    public void setOtherEmail(String otherEmail) {
        this.otherEmail = otherEmail;
    }

    @Override
    public String toString() {
        return "JBGLVO{" +
                "name='" + name + '\'' +
                ", workStart='" + workStart + '\'' +
                ", workEnd='" + workEnd + '\'' +
                ", workTime='" + workTime + '\'' +
                ", workContent='" + workContent + '\'' +
                ", leader='" + leader + '\'' +
                ", otherEmail='" + otherEmail + '\'' +
                '}';
    }
}
