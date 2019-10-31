package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok().body(CategoryDto.builder().build());
    }

    @PostMapping
    public ResponseEntity createCategory(@Valid @RequestBody CategoryDto categoryDto) throws URISyntaxException {
        URI location = new URI("/api/v1/category/1");
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable("categoryId") Long categoryId, @Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity deleteCategoryById(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.noContent().build();
    }
}
