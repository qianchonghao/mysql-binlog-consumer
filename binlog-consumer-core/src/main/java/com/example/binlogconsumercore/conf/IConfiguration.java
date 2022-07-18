package com.example.binlogconsumercore.conf;

import com.alibaba.fastjson.JSON;
import com.example.binlogconsumercore.listener.BinlogListener;
import com.example.binlogconsumercore.model.BinlogSyncConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BinlogSyncConfig.class)
public class IConfiguration {
    @Bean
    public BinlogListener binlogListener(BinlogSyncConfig config){
        System.out.println(">>>>>>>>>>>>>> binlogConfig:" + JSON.toJSONString(config));
        return new BinlogListener();
    }
}
