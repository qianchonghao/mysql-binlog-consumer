package com.example.binlogconsumercore.listener;

import com.example.binlogconsumercore.util.PropertiesUtils;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

import java.io.IOException;
import java.util.Properties;

public class BinlogListener {
    private void init(){

        BinaryLogClient client = new BinaryLogClient("hostname", 3306, "username", "password");
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(
                EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
        );
        client.setEventDeserializer(eventDeserializer);
        client.registerEventListener(new BinaryLogClient.EventListener() {

            @Override
            public void onEvent(Event event) {
//        ...
            }
        });

        try {
            client.connect();
        } catch (IOException e) {
            System.out.println("binlog client connect failed");
            e.printStackTrace();
        }
    }
    private BinaryLogClient buildBinaryLogClient(){
        Properties properties = PropertiesUtils.getProperties();



        return null;
    }
}

