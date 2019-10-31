package com.docswebapps.homeinventoryservice.web.model;

import lombok.Builder;

import java.time.OffsetDateTime;

public class MakeDto extends BaseDto {
    @Builder
    public MakeDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate) {
        super(id, name, createdDate, lastModifiedDate);
    }
}
