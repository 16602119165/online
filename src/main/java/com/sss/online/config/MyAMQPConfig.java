package com.sss.online.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @create 2019-06-24-10:52
 */
@Configuration//rabbitmq自定义配置类，可以根据RabbitMQTemplate类来
public class MyAMQPConfig {

    //修改序列化规则
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();

    }

}
