package com.docswebapps.homeinventoryservice.web.model;

import lombok.Builder;

import java.time.OffsetDateTime;

public class LocationDto extends BaseDto {
    @Builder
    public LocationDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate) {
        super(id, name, createdDate, lastModifiedDate);
    }
}
