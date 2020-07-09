package com.sss.online.pojo;

/**
 * @author
 * @create 2019-06-25-13:53
 */
//角色表
public class ShiroRole {
    int roleId;
    String roleName;
    String empName;
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "ShiroRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
