package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.OwnerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    @PostMapping
    public ResponseEntity createNewOwner(@Valid @RequestBody OwnerDto ownerDto) throws URISyntaxException {
        URI location = new URI("/api-v1/owner/1");
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity getOwnerByID(@PathVariable("ownerId") Long ownerId) {
        return ResponseEntity.ok().body(OwnerDto.builder().build());
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity updateOwnerById(@PathVariable("ownerId") Long ownerId, @Valid @RequestBody OwnerDto ownerDto) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity deleteOwnerById(@PathVariable("ownerId") Long ownerId) {
        return ResponseEntity.noContent().build();
    }
}
