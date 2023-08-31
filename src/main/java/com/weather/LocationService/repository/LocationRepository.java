package com.weather.LocationService.repository;

import com.weather.LocationService.model.SavedLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<SavedLocation, Long> {
}
