package com.docswebapps.homeinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "models")
public class Model extends Base {
    @ManyToOne
    private Make modelMake;

    @OneToMany(mappedBy = "itemModel", fetch = FetchType.LAZY)
    private Collection<Item> items;

    @Builder
    public Model(Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long version, Make modelMake
    , Collection<Item> items) {
        super(id, name, createdDate, lastModifiedDate, version);
        this.modelMake = modelMake;
        this.items = items;
    }
}
