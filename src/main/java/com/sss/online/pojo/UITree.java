package com.sss.online.pojo;

import java.util.List;

/**
 * @author
 * @create 2019-06-25-10:32
 */
public class UITree {
    int id;
    String text;
    String state;
    boolean checked;
    List<UITree> children;
    String iconCls = "icon-blank";
    public String menuUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<UITree> getChildren() {
        return children;
    }

    public void setChildren(List<UITree> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public String toString() {
        return "UITree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", checked=" + checked +
                ", children=" + children +
                ", iconCls='" + iconCls + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
