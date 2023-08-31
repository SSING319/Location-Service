package com.weather.LocationService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.LocationService.model.SavedLocation;
import com.weather.LocationService.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class SavedLocationService {

    private static final String API_BASE_URL = "http://api.zippopotam.us";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final LocationRepository locationRepository;

    @Autowired
    public SavedLocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    //GET
    public List<SavedLocation> getAllSavedLocations() {
        return locationRepository.findAll();
    }
    public SavedLocation getSavedLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    //POST
    public SavedLocation createLocation(String countryAbbrevation, long pinCode) throws JsonProcessingException {
        String apiUrl = API_BASE_URL + "/" + countryAbbrevation + "/" + pinCode;

        JsonNode jsonNode = objectMapper.readTree(restTemplate.getForObject(apiUrl, String.class));

        long post_code = jsonNode.get("post code").asLong();
        String country = jsonNode.get("country").asText();

        //places is an array and it has only 1 object and inside it we have rest of the fields
        JsonNode placesNode = jsonNode.get("places").get(0);
        String place_name = placesNode.get("place name").asText();
        double longitude = placesNode.get("longitude").asDouble();
        double latitude = placesNode.get("latitude").asDouble();
        String state = placesNode.get("state").asText();

        SavedLocation location = SavedLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .place_name(place_name)
                .state(state)
                .country(country)
                .post_code(post_code)
                .build();
        return locationRepository.save(location);
    }

    //DELETE
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
