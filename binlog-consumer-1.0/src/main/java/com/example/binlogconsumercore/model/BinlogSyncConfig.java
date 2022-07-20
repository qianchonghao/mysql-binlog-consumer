package com.example.binlogconsumercore.model;

import com.example.binlogconsumercore.model.config.DBConfig;
import com.example.binlogconsumercore.model.config.RedisConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("syncconfig")
public class BinlogSyncConfig {
    // camel -> snake

    private RedisConfig positionRedisConfig;
    // ConfigurationProperties 的Map属性映射多个dbConfig
    private Map<String,DBConfig> dbConfig;

    public RedisConfig getPositionRedisConfig() {
        return positionRedisConfig;
    }

    public void setPositionRedisConfig(RedisConfig positionRedisConfig) {
        this.positionRedisConfig = positionRedisConfig;
    }

    public Map<String, DBConfig> getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(Map<String, DBConfig> dbConfig) {
        this.dbConfig = dbConfig;
    }
}
