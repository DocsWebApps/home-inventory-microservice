package com.docswebapps.homeinventoryservice.web.model;

import lombok.Builder;

import java.time.OffsetDateTime;

public class OwnerDto extends BaseDto {
    @Builder
    public OwnerDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate) {
        super(id, name, createdDate, lastModifiedDate);
    }
}
