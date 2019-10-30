package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.MakeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/make")
public class MakeController {

    @Value("${INSTANCE_ID}")
    private String instanceId;

    @GetMapping("/test")
    public ResponseEntity<MakeDto> getTestDTO() {
        MakeDto makeDto = MakeDto.builder()
                .id(0L)
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
    public ResponseEntity createNewMake(@Valid @RequestBody MakeDto makeDto) throws Exception{
        // To-Do Implementation
        URI location = new URI("/api/v1/make/1");
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{makeId}")
    public ResponseEntity updateMakeById(@PathVariable("makeId") Long makeId, @Valid @RequestBody MakeDto makeDto) {
        // To-Do Implementation
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{makeId}")
    public ResponseEntity deleteMakeById(@PathVariable("makeId") Long makeId) {
        // To-Do Implementation
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List> handleExceptions(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(error-> errors.add("ERROR: " + error.getField() + " - " + error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
