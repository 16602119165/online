package com.sss.online;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan(value = "com.sss.online.dao")
@SpringBootApplication
public class OnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineApplication.class, args);
    }

}
