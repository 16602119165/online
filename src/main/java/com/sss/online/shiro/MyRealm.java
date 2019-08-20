package com.sss.online.shiro;

import com.sss.online.pojo.Employee;
import com.sss.online.serviceimpl.EmployeeServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    EmployeeServiceImpl employeeService;

    public void setName(String name){
        super.setName("myRealm");
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        System.out.println("token中携带的认证信息"+ principal);
        Employee employee = employeeService.selectByName(principal);
        ByteSource credentialsSalt = ByteSource.Util.bytes(employee.getSalt());
        Object hashedCredentials = employee.getPassword();
        if (employee == null){
            return null;
        }else {
            SimpleAuthenticationInfo info = null;//new SimpleAuthenticationInfo(name,employee.getPassword(),"myRealm");
            info = new SimpleAuthenticationInfo(principal,hashedCredentials,credentialsSalt,this.getName());
            return info;
        }
    }
}
