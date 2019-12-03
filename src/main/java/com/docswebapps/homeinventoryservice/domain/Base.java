package com.docswebapps.homeinventoryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp lastModifiedDate;

    @Version
    @Column(nullable = false)
    private Long version;
}
