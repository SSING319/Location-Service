package com.weather.LocationService.controller;


import com.weather.LocationService.DTO.LocationInfo;
import com.weather.LocationService.service.CurrentLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/current-location")
public class CurrentLocationController {
    private final CurrentLocationService currentLocationService;

    @Autowired
    public CurrentLocationController(CurrentLocationService currentLocationService) {
        this.currentLocationService = currentLocationService;
    }
    // Will provide you with the Ip, city, state, country
    @GetMapping()
    public LocationInfo getCurrentLocation() {
        return currentLocationService.getCurrentLocation();
    }

}
