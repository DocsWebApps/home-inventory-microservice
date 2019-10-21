package com.docswebapps.homeinventoryservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
}
