package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.CategoryService;
import com.docswebapps.homeinventoryservice.web.model.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> allCategories = this.categoryService.getAllCategories();
        return allCategories.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(allCategories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
        return categoryDto == null
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok().body(categoryDto);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createCategory(@Valid @RequestBody CategoryDto categoryDto) throws URISyntaxException {
        Long id = this.categoryService.saveCategory(categoryDto);
        URI location = new URI("/api/v1/category/" + id);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable("categoryId") Long categoryId, @Valid @RequestBody CategoryDto categoryDto) {
        return this.categoryService.updateCategory(categoryId,categoryDto)
            ? ResponseEntity.noContent().build()
            : ResponseEntity.badRequest().body("Error updating category, contact an administrator!");
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.deleteCategory(categoryId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body("Error deleting category, contact an administrator!");
    }
}
