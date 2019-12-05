package com.docswebapps.homeinventoryservice.web.model;

import com.docswebapps.homeinventoryservice.domain.Make;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ModelDto extends BaseDto {
    private String modelMakeName;

    @Builder
    public ModelDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate, Make modelMake) {
        super(id, name, createdDate, lastModifiedDate);
        this.modelMakeName = modelMake.getName();
    }
}
