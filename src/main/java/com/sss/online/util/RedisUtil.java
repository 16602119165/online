package com.sss.online.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author
 * @create 2019-06-27-16:36
 */
public class RedisUtil {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    public void setValue(String key,Object data){
        redisTemplate.opsForValue().set(key,data);
    }
}
