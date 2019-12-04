package com.docswebapps.homeinventoryservice.service;

import com.docswebapps.homeinventoryservice.web.model.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    Long saveCategory(CategoryDto categoryDto);
    boolean updateCategory(Long id, CategoryDto categoryDto);
    boolean deleteCategory(Long id);
}
