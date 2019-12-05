package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.LocationService;
import com.docswebapps.homeinventoryservice.web.model.LocationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        List<LocationDto> allLocations = this.locationService.getAllLocations();
        return allLocations.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(allLocations);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createNewLocation(@Valid @RequestBody LocationDto locationDto) throws URISyntaxException {
        Long id = this.locationService.saveLocation(locationDto);
        URI location = new URI("/api/v1/location/" + id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable("locationId") Long locationId) {
        LocationDto locationDto = this.locationService.getLocationById(locationId);
        return locationDto == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(locationDto);
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<String> updateLocationById(@PathVariable("locationId") Long locationId, @Valid @RequestBody LocationDto locationDto) {
        return this.locationService.updateLocation(locationId, locationDto)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error updating category, contact an administrator!");
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocationById(@PathVariable("locationId") Long locationId) {
        return this.locationService.deleteLocation(locationId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error deleting category, contact an administrator!");
    }
}
