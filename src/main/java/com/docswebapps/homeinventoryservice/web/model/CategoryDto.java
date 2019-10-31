package com.docswebapps.homeinventoryservice.web.model;

import lombok.Builder;

import java.time.OffsetDateTime;

public class CategoryDto extends BaseDto {
    @Builder
    public CategoryDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate) {
        super(id, name, createdDate, lastModifiedDate);
    }
}
