package com.docswebapps.homeinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category extends Base {
    @OneToMany(mappedBy = "itemCategory", fetch = FetchType.LAZY)
    private Collection<Item> items;

    @Builder
    public Category(Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long version
    , Collection<Item> items) {
        super(id, name, createdDate, lastModifiedDate, version);
        this.items = items;
    }
}
