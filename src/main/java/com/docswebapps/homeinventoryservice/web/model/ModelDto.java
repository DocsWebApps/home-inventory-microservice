package com.docswebapps.homeinventoryservice.web.model;

import lombok.Builder;

import java.time.OffsetDateTime;

public class ModelDto extends BaseDto {
    @Builder
    public ModelDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate) {
        super(id, name, createdDate, lastModifiedDate);
    }
}
