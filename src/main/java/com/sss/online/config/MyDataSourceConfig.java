package com.sss.online.config;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyDataSourceConfig {

    //注册数据源，并绑定配置文件中以spring.datasource前缀开头的相关属性
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        //return DataSourceBuilder.create().build();springboot 2.0以上，在整合druid时，需要导入log4j依赖，如果不导入则可以使用
        //DataSourceBuilder.create().build()来构建;
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean staViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        //设置servlet初始化参数
        initParams.put("loginUsername","admin");//登陆名
        initParams.put("loginPassword","123456");//密码
        initParams.put("allow","");//默认就是允许所有访问
        initParams.put("deny","192.168.15.21");//拒绝相对应的id访问
        bean.setInitParameters(initParams);
        //加载到容器中
        return bean;
    }
    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        //设置filter初始化参数、
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");//排除静态资源和请求
        bean.setInitParameters(initParams);
        //拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        //加载到容器中
        return bean;
    }


}
