package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.LocationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    @PostMapping
    public ResponseEntity createNewLocation(@RequestBody LocationDto locationDto) throws URISyntaxException {
        URI location = new URI("/api/v1/location/1");
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{locationId}")
    public ResponseEntity getLocationById(@PathVariable("locationId") Long locationId) {
        return ResponseEntity.ok().body(LocationDto.builder().build());
    }

    @PutMapping("/{locationId}")
    public ResponseEntity updateLocationById(@PathVariable("locationId") Long locationId, LocationDto locationDto) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity deleteLocationById(@PathVariable("locationId") Long locationId) {
        return ResponseEntity.noContent().build();
    }

}
