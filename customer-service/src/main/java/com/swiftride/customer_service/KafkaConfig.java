package com.swiftride.customer_service;

import com.swiftride.customer_service.Entities.LocationData;
import com.swiftride.customer_service.Entities.LocationHistory;
import com.swiftride.customer_service.Repositories.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @Autowired // Add this to inject your Repository
    private LocationRepository locationRepository;

    @KafkaListener(topics = "location-update-topic", groupId = "group-1")
    public void handleLocation(LocationData data) {
        System.out.println("Received Object -> Rider: " + data.getRiderId() + " is at " + data.getLatitude());

        // 1. Create the Entity object
        LocationHistory history = new LocationHistory();

        // 2. Map data from Kafka (LocationData) to Entity (LocationHistory)
        history.setRiderId(data.getRiderId());
        history.setLatitude(data.getLatitude());
        history.setLongitude(data.getLongitude());
        history.setTimestamp(java.time.LocalDateTime.now());

        // 3. Save it to the database!
        locationRepository.save(history);
        System.out.println("Successfully saved to H2 Database!");
    }
}
