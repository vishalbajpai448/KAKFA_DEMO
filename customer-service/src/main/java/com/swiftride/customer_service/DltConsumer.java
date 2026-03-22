package com.swiftride.customer_service;

import com.swiftride.customer_service.Entities.LocationData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class DltConsumer {

    @KafkaListener(topics = "location-update-topic-dlt", groupId = "dlt-monitor-group")
    public void handleDltMessages(LocationData data,
                                  @Header(KafkaHeaders.ORIGINAL_TOPIC) String topic,
                                  @Header(KafkaHeaders.EXCEPTION_MESSAGE) String errorMessage) {

        System.err.println("🚨 ALERT: Message failed in topic: " + topic);
        System.err.println("❌ Error Reason: " + errorMessage);
        System.err.println("📦 Failed Data for Rider: " + data.getRiderId());
    }
}
