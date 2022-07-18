package com.example.binlogconsumercore.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties getProperties(){
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("classpath::application.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("properties load failed");
        }
        return properties;
    }
}
