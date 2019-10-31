package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.ModelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/model")
public class ModelController {

    @GetMapping("/{modelId}")
    public ResponseEntity<ModelDto> getModelById(@PathVariable("modelId") Long modelId) {
        return ResponseEntity.ok().body(ModelDto.builder().build());
    }

    @PostMapping
    public ResponseEntity createNewModel(@Valid @RequestBody ModelDto modelDto) throws URISyntaxException {
        URI location = new URI("/api");
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{modelId}")
    public ResponseEntity updateModelById(@PathVariable("modelId") Long modelId, @Valid @RequestBody ModelDto modelDto) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{modelId}")
    public ResponseEntity deleteModelById(@PathVariable("modelId") Long modelId) {
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
