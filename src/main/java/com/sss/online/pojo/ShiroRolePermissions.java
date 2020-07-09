package com.sss.online.pojo;

/**
 * @author
 * @create 2019-06-25-14:21
 */
public class ShiroRolePermissions {
    int id;
    int roleId;
    int permissions;
    String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "ShiroRolePermissions{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissions=" + permissions +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
