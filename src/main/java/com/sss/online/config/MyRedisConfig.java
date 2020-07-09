package com.sss.online.config;

import com.sss.online.dto.EmployeeDto;
import com.sss.online.pojo.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author
 * @create 2019-06-05-15:15
 */
//该自动配置类，实际上可以不使用，条件是使用其他的json转化jar包，而这种方式，是通过修改redis的序列化
    //机制来修改存储的格式。
@Configuration //表明这是一个配置类
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, EmployeeDto> employeeDtoRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, EmployeeDto> template = new RedisTemplate<Object, EmployeeDto>();
        template.setConnectionFactory(redisConnectionFactory);
        //设置一个json序列化器
        Jackson2JsonRedisSerializer<EmployeeDto> ser = new Jackson2JsonRedisSerializer<EmployeeDto>(EmployeeDto.class);
        //template 设置默认的序列化器为刚才设置的json序列化器。
        template.setDefaultSerializer(ser);
        return template;
    }
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // 设置value的序列化规则和 key的序列化规则
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(genericJackson2JsonRedisSerializer);
        template.setDefaultSerializer(genericJackson2JsonRedisSerializer);
        template.setEnableDefaultSerializer(true);
        template.afterPropertiesSet();
        return template;
    }

}
