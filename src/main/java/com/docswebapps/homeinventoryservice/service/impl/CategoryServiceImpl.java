package com.docswebapps.homeinventoryservice.service.impl;

import com.docswebapps.homeinventoryservice.mappers.CategoryMapper;
import com.docswebapps.homeinventoryservice.repository.CategoryRepository;
import com.docswebapps.homeinventoryservice.service.CategoryService;
import com.docswebapps.homeinventoryservice.web.model.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return this.categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return this.categoryRepository.findById(id)
                .map(categoryMapper::categoryToCategoryDto)
                .orElse(null);
    }

    @Override
    public Long saveCategory(CategoryDto categoryDto) {
        return this.categoryRepository
                .save(this.categoryMapper.categoryDtoToCategory(categoryDto))
                .getId();
    }

    @Override
    public boolean updateCategory(Long id, CategoryDto categoryDto) {
        return this.categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDto.getName());
                    this.categoryRepository.save(category);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return this.categoryRepository.findById(id)
                .map(category -> {
                    this.categoryRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
