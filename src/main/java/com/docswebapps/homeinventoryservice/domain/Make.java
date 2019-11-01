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
@Table(name = "makes")
public class Make extends Base {
    @OneToMany(mappedBy="modelMake", fetch = FetchType.LAZY)
    private Collection<Model> models;

    @Builder
    public Make(Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long version, Collection<Model> models) {
        super(id, name, createdDate, lastModifiedDate, version);
        this.models = models;
    }
}
