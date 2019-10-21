package com.docswebapps.homeinventoryservice.web.controller.v1;
import com.docswebapps.homeinventoryservice.web.model.ModelDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/model")
public class ModelController {

    @GetMapping("/{modelId}")
    public ResponseEntity<ModelDto> getModelById(@PathVariable("modelId") Long modelId) {
        return ResponseEntity.ok().body(ModelDto.builder().build());
    }

    @PostMapping
    public ResponseEntity saveNewModel(@RequestBody ModelDto modelDto) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{modelId}")
    public ResponseEntity updateModelById(@PathVariable("modelId") Long modelId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{modelId}")
    public ResponseEntity deleteModelById(@PathVariable("modelId") Long modelId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
