package com.example.binlogconsumercore.redis;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RedisTest implements InitializingBean {
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public void afterPropertiesSet() throws Exception {
        redisUtils.set("k1", "lm_" + new Date().getTime());
        System.out.println(">>>>>>>>>>>>> redis result : key = k1 & value = " + String.valueOf(redisUtils.get("k1")));
    }
}
