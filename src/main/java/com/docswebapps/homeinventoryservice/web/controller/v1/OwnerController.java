package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.OwnerService;
import com.docswebapps.homeinventoryservice.web.model.OwnerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> allOwners = this.ownerService.getAllOwners();
        return allOwners.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(allOwners);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createNewOwner(@Valid @RequestBody OwnerDto ownerDto) throws URISyntaxException {
        Long id = this.ownerService.saveOwner(ownerDto);
        URI location = new URI("/api-v1/owner/" + id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDto> getOwnerByID(@PathVariable("ownerId") Long ownerId) {
        OwnerDto ownerDto = this.ownerService.getOwnerById(ownerId);
        return ownerDto == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(ownerDto);
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<String> updateOwnerById(@PathVariable("ownerId") Long ownerId, @Valid @RequestBody OwnerDto ownerDto) {
        return this.ownerService.updateOwner(ownerId, ownerDto)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error updating owner, contact an administrator!");
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.deleteOwner(ownerId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error deleting owner, contact an administrator!");
    }
}
