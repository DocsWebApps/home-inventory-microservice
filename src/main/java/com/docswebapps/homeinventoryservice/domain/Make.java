package com.docswebapps.homeinventoryservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "makes")
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime lastModifiedDate;

    @OneToMany(mappedBy="modelMake", fetch = FetchType.LAZY)
    private Collection<Model> models;

    @Version
    private Long version;
}
