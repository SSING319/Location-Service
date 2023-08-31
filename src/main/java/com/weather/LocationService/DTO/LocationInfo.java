package com.weather.LocationService.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationInfo {
    private String ip;
    private double latitude;
    private double longitude;
    private String city;
    private String region_name;
    private String country_name;
}
