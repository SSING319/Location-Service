package com.weather.LocationService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavedLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long location_id;
    private String place_name;
    private String state;
    private String country;
    private long post_code;
    private double latitude;
    private double longitude;
}
