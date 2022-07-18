package com.example.binlogconsumercore;

import com.example.binlogconsumercore.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BinlogConsumerCoreApplicationTests {
    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {

    }

    @Test
    void redisTest() {
        redisUtils.set("k1", "lm_" + new Date().getTime());
        System.out.println("redis result :" + String.valueOf(redisUtils.get("k1")));
    }
}
