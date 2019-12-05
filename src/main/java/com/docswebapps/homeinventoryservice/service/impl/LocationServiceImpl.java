package com.docswebapps.homeinventoryservice.service.impl;

import com.docswebapps.homeinventoryservice.mappers.LocationMapper;
import com.docswebapps.homeinventoryservice.repository.LocationRepository;
import com.docswebapps.homeinventoryservice.service.LocationService;
import com.docswebapps.homeinventoryservice.web.model.LocationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return this.locationRepository.findAll()
                .stream()
                .map(locationMapper::locationToLocationDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto getLocationById(Long id) {
        return this.locationRepository.findById(id)
                .map(locationMapper::locationToLocationDto)
                .orElse(null);
    }

    @Override
    public Long saveLocation(LocationDto locationDto) {
        return this.locationRepository
                .save(this.locationMapper.locationDtoToLocation(locationDto))
                .getId();
    }

    @Override
    public boolean updateLocation(Long id, LocationDto locationDto) {
        return this.locationRepository.findById(id)
                .map(location -> {
                    location.setName(locationDto.getName());
                    this.locationRepository.save(location);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteLocation(Long id) {
        return this.locationRepository.findById(id)
                .map(location -> {
                    this.locationRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
