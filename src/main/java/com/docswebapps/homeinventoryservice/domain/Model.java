package com.docswebapps.homeinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "models")
public class Model extends Base{
    @ManyToOne
    private Make modelMake;

    @Builder
    public Model(Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long version, Make modelMake) {
        super(id, name, createdDate, lastModifiedDate, version);
        this.modelMake = modelMake;
    }
}
