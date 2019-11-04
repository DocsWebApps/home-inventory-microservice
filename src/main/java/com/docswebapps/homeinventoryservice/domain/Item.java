package com.docswebapps.homeinventoryservice.domain;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private Double cost;

    @Column
    private String serialNumber;

    @Column
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private boolean estimatedDate;

    @Column(nullable = false)
    private boolean haveReceipt;

    @Column
    private String additionalInfo;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp lastModifiedDate;

    @ManyToOne
    private Model itemModel;

    @ManyToOne
    private Category itemCategory;

    @ManyToOne
    private Location itemLocation;

    @ManyToOne
    private Owner itemOwner;
}
