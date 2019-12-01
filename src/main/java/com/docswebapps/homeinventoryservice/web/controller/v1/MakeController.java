package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.MakeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/make")
public class MakeController {

    @GetMapping("/{makeId}")
    public ResponseEntity<MakeDto> getMakeById(@PathVariable("makeId") Long makeId) {
        return ResponseEntity.ok().body(MakeDto.builder().build());
    }

    @PostMapping
    public ResponseEntity createNewMake(@Valid @RequestBody MakeDto makeDto) throws Exception{
        URI location = new URI("/api/v1/make/1");
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{makeId}")
    public ResponseEntity updateMakeById(@PathVariable("makeId") Long makeId, @Valid @RequestBody MakeDto makeDto) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{makeId}")
    public ResponseEntity deleteMakeById(@PathVariable("makeId") Long makeId) {
        return ResponseEntity.noContent().build();
    }
}
