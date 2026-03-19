package com.swiftride.delivery_service.Services;

import com.swiftride.delivery_service.AppConstants;
import com.swiftride.delivery_service.dto.LocationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updatelocation(LocationData data) {
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,data);
        return true;
    }

}
