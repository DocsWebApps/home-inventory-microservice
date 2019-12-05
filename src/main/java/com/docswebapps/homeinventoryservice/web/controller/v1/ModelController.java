package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.ModelService;
import com.docswebapps.homeinventoryservice.web.model.ModelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<ModelDto>> getAllModels() {
        List<ModelDto> allModels = this.modelService.getAllModels();
        return allModels.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(allModels);
    }

    @GetMapping("/{modelId}")
    public ResponseEntity<ModelDto> getModelById(@PathVariable("modelId") Long modelId) {
        ModelDto modelDto = this.modelService.getModelById(modelId);
        return modelDto == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(modelDto);
    }

    @PostMapping
    public ResponseEntity<String> createNewModel(@Valid @RequestBody ModelDto modelDto) throws URISyntaxException {
        Long id = this.modelService.saveModel(modelDto);
        return id > 0
                ? ResponseEntity.created(new URI("/api/v1/model/" + id)).build()
                : ResponseEntity.badRequest().body("Error saving model, contact an administrator!");
    }

    @PutMapping("/{modelId}")
    public ResponseEntity<String> updateModelById(@PathVariable("modelId") Long modelId, @Valid @RequestBody ModelDto modelDto) {
        return this.modelService.updateModel(modelId,modelDto)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error updating model, contact an administrator!");
    }

    @DeleteMapping("/{modelId}")
    public ResponseEntity<String> deleteModelById(@PathVariable("modelId") Long modelId) {
        return this.modelService.deleteModel(modelId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error deleting model, contact an administrator!");
    }
}
