package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.MakeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/api/v1/make")
public class MakeController {

    @Value("${INSTANCE_ID}")
    private String instanceId;

    @GetMapping("/test")
    public ResponseEntity<MakeDto> getTestDTO() {
        MakeDto makeDto = MakeDto.builder()
                .id(1L)
                .name(this.instanceId)
                .createdDate(OffsetDateTime.now(ZoneId.systemDefault()))
                .lastModifiedDate(OffsetDateTime.now(ZoneId.systemDefault()))
                .build();
        return ResponseEntity.ok().body(makeDto);
    }

    @GetMapping("/{makeId}")
    public ResponseEntity<MakeDto> getMakeById(@PathVariable("makeId") Long makeId) {
        // To-Do Implementation
        return ResponseEntity.ok().body(MakeDto.builder().build());
    }

    @PostMapping
    public ResponseEntity saveNewMake(@RequestBody MakeDto makeDto) {
        // To-Do Implementation
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{makeId}")
    public ResponseEntity updateMakeById(@PathVariable("makeId") Long makeId) {
        // To-Do Implementation
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{makeId}")
    public ResponseEntity deleteMakeById(@PathVariable("makeId") Long makeId) {
        // To-Do Implementation
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
