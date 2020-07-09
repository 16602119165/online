package com.sss.online.config;


import com.sss.online.shiro.MyRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class MyShiroConfig {
    //1.创建ShiroFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        /*
        shiro 内置过滤器：可以实现权限相关的拦截
        常用的过滤器有：
        anon: 无需认证（登陆）可以访问
        authc : 必须认证才可以访问
        user ： 如果使用rememberme的功能可以直接访问
        perms: 该资源必须得到资源权限才可以访问
        role：该资源必须得到角色权限才可以访问
         */
        Map<String,String> fiterMap =new LinkedHashMap<String, String>();
        fiterMap.put("/page/**" ,"authc");
        shiroFilterFactoryBean.setLoginUrl("/");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fiterMap);
        System.out.println("拦截器注入securityManage管理器");
        return shiroFilterFactoryBean;
    }
    //2.创建DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        System.out.println("securityManager注入自定义realm");
        return defaultWebSecurityManager;
    }


    //3.创建realm对象
    @Bean
    public MyRealm myRealm(HashedCredentialsMatcher credentialsMatcher){
        MyRealm realm = new MyRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        System.out.println("凭证匹配器注入自定义realm");
        return realm;
    }

    //4.盐值加密以及加密算法md5 该bean是给自定义realm使用的
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置凭证匹配器的加密算法
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置加密迭代次数
        credentialsMatcher.setHashIterations(1);
        System.out.println("凭证匹配器初始化");
        return credentialsMatcher;
    }

}
