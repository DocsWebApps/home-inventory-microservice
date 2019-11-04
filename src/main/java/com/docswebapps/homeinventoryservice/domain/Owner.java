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
@Table(name = "owners")
public class Owner extends Base {
    @OneToMany(mappedBy = "itemOwner", fetch = FetchType.LAZY)
    private Collection<Item> items;

    @Builder
    public Owner(Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long version,
                 Collection<Item> items) {
        super(id, name, createdDate, lastModifiedDate, version);
        this.items = items;
    }

}
