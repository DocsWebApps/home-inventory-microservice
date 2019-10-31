package com.docswebapps.homeinventoryservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
class BaseDto {
    @Null
    private Long id;

    @NotBlank
    private String name;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;
}
