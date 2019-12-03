package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.MakeService;
import com.docswebapps.homeinventoryservice.web.model.MakeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/make")
public class MakeController {
    private final MakeService makeService;

    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @GetMapping
    public ResponseEntity<List<MakeDto>> getAllMakes() {
        List<MakeDto> allMakes = this.makeService.getAllMakes();
        return allMakes.isEmpty()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok().body(allMakes);
    }

    @GetMapping("/{makeId}")
    public ResponseEntity<MakeDto> getMakeById(@PathVariable("makeId") Long makeId) {
        MakeDto makeDto = this.makeService.getMakeById(makeId);
        return makeDto.toString().isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(makeDto);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createNewMake(@Valid @RequestBody MakeDto makeDto) throws Exception {
        Long id = this.makeService.saveMake(makeDto);
        URI location = new URI("/api/v1/make/" + id);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{makeId}")
    public ResponseEntity<String> updateMakeById(@PathVariable("makeId") Long makeId, @Valid @RequestBody MakeDto makeDto) {
        return this.makeService.updateMake(makeId, makeDto)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error updating make, contact an administrator!");
    }

    @DeleteMapping("/{makeId}")
    public ResponseEntity<String> deleteMakeById(@PathVariable("makeId") Long makeId) {
        return this.makeService.deleteMake(makeId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error deleting make, contact an administrator!");
    }
}
