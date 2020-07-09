package com.sss.online.config;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
//mybatis整合springboot，使用纯注解版时，若java类中的变量与数据库中的字段是驼峰命名法时
//会造成对应表不上。应该添加一个定制配置ConfigurationCustomizer来开启驼峰命名法
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        // new 接口后面并实现其中的方法，属于匿名类的实现方法。
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
