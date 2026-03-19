package com.swiftride.customer_service.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationData {
    private String riderId;
    private double latitude;
    private double longitude;
    private String status;
}
