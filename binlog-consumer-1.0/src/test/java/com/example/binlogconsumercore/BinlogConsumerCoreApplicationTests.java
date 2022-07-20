package com.example.binlogconsumercore;

import com.example.binlogconsumercore.redis.RedisUtils;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventHeaderV4;
import com.github.shyiko.mysql.binlog.event.EventType;
import com.github.shyiko.mysql.binlog.event.RotateEventData;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
