package com.sss.online.pojo;

/**
 * @author
 * @create 2019-06-28-16:00
 */
public class QJLX {
    int id;
    String qjlx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQjlx() {
        return qjlx;
    }

    public void setQjlx(String qjlx) {
        this.qjlx = qjlx;
    }

    public QJLX() {
    }

    public QJLX(int id, String qjlx) {
        this.id = id;
        this.qjlx = qjlx;
    }

    @Override
    public String toString() {
        return "QJLX{" +
                "id=" + id +
                ", qjlx='" + qjlx + '\'' +
                '}';
    }
}
