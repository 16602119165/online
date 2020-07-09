package com.sss.online.pojo;

/**
 * @author
 * @create 2019-06-25-10:42
 */
public class ShiroPermissions {
    int id;
    String menuName;
    int pId;
    String menuUrl;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public String toString() {
        return "ShiroPermissions{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", pId=" + pId +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
