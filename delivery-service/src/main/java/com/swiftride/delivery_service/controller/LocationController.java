package com.swiftride.delivery_service.controller;

import com.swiftride.delivery_service.Services.KafkaProducerService;
import com.swiftride.delivery_service.dto.LocationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestBody LocationData data) {
        this.kafkaProducerService.updatelocation(data);
        return ResponseEntity.ok("JSON Location Sent!");
    }
}
