package com.docswebapps.homeinventoryservice.service;

import com.docswebapps.homeinventoryservice.web.model.LocationDto;

import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocations();
    LocationDto getLocationById(Long id);
    Long saveLocation(LocationDto locationDto);
    boolean updateLocation(Long id, LocationDto locationDto);
    boolean deleteLocation(Long id);
}
