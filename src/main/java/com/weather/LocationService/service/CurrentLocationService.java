package com.weather.LocationService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.LocationService.DTO.IP;
import com.weather.LocationService.DTO.LocationInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CurrentLocationService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LocationInfo getCurrentLocation() {
        String accessKey = System.getenv("ACCESS_KEY");
        String apiBaseUrl = "http://api.ipstack.com/";
        try {
            IP ip = restTemplate.getForObject("https://api.ipify.org?format=json", IP.class);
            String apiUrl = apiBaseUrl + ip.getIp() + "?access_key=" + accessKey;
            String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
            return objectMapper.readValue(jsonResponse, LocationInfo.class);
        } catch (IOException e) {
            System.out.println("Error Fetching Location data");
            e.printStackTrace();
            return null;
        }
    }
}
