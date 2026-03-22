package com.microservice.api_gateway.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @PostMapping("/delivery")
    public Map<String,String> deliveryFallback() {
        return Map.of(
                "status", "Service Unavailable",
                "message", "The Delivery Tracking service is currently down. Please try again later.",
                "code", "SERVICE_MAINTENANCE"
        );
    }
}
