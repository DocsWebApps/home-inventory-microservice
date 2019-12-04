package com.docswebapps.homeinventoryservice.mappers;

import com.docswebapps.homeinventoryservice.domain.Category;
import com.docswebapps.homeinventoryservice.web.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DateMapper.class)
public interface CategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "items", ignore = true)
    Category categoryDtoToCategory(CategoryDto categoryDto);
}
