package com.weather.LocationService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.LocationService.DTO.RequestData;
import com.weather.LocationService.model.SavedLocation;
import com.weather.LocationService.service.SavedLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved-locations")
public class SavedLocationController {
    private final SavedLocationService locationService;

    @Autowired
    public SavedLocationController(SavedLocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<SavedLocation> getAllLocations() {
        return locationService.getAllSavedLocations();
    }

    @GetMapping("/{id}")
    public SavedLocation getLocationById(@PathVariable Long id) {
        return locationService.getSavedLocationById(id);
    }

    @PostMapping
    public SavedLocation createLocation(@RequestBody RequestData requestData) throws JsonProcessingException {
        String countryAbbrevation = requestData.getCountryAbbrevation();
        long pinCode = requestData.getPinCode();
        return locationService.createLocation(countryAbbrevation, pinCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok("Location deleted successfully");
    }
}

