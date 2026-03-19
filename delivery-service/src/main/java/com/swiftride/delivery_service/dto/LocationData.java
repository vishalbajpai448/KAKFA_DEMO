package com.swiftride.delivery_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationData {
    private String riderId;
    private double latitude;
    private double longitude;
    private String status;
}
