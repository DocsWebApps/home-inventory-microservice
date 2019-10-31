package com.docswebapps.homeinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category extends Base {
    @Builder
    public Category(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate, Long version) {
        super(id, name, createdDate, lastModifiedDate, version);
    }
}
