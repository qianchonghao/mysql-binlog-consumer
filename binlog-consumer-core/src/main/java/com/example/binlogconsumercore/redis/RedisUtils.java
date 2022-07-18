package com.example.binlogconsumercore.redis;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    // get
    public Object get(String key){
        return (key == null?null:redisTemplate.opsForValue().get(key));
    }

    // set
    public boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // set and set expire
    public boolean set(String key, Object value, long expire){
        try {
            redisTemplate.opsForValue().set(key,value,expire, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // del
    public long del(String ...keys){
        try {
            if (keys.length == 1) {
                return redisTemplate.delete(keys[0])?1:0;
            } else {
                return redisTemplate.delete(Lists.newArrayList(keys));
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
