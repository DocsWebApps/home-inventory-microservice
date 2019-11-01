package com.docswebapps.homeinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location extends Base {
    @Builder
    public Location(Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long  version) {
        super(id, name, createdDate, lastModifiedDate, version);
    }
}
