package com.sss.online.pojo;

/**
 * @author
 * @create 2019-06-28-15:54
 */
//前端combobox 插件返回json格式必须的字段
public class UICombobox {
    private String id;
    private String text;
    private Boolean selected = false;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Boolean getSelected() {
        return selected;
    }
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "UICombobox{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", selected=" + selected +
                '}';
    }
}
