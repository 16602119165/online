package com.sss.online.pojo;

import java.util.List;

/**
 * @author
 * @create 2019-07-29-16:06
 */
public class UIComboTree {
    private int id;
    private String text;
    private List<UIComboTree> children;

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

    public List<UIComboTree> getChildren() {
        return children;
    }

    public void setChildren(List<UIComboTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "UIComboTree{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", children=" + children +
                '}';
    }
}
