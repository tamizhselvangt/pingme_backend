package com.tamizhselvan.pingme.utils;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "chat-message", groupId = "chat-group")
    public void listen(String message) {
        System.out.println("📨 Received Message: " + message);
        // You can then trigger websocket update or logic here
    }
}
