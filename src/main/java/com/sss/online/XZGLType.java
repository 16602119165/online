package com.sss.online;

/**
 * @author
 * @create 2019-07-04-16:26
 */
public enum XZGLType {
    out(10,"外出"),
    qingjia(20,"请假"),
    chuchai(30,"出差"),
    jiaban(40,"加班");
    private int code;
    private String typeName;

    private XZGLType(int code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
