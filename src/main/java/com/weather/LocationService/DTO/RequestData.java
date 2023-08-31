package com.weather.LocationService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {
    private String countryAbbrevation;
    private Long pinCode;
}
