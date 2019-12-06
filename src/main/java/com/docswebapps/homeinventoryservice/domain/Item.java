package com.docswebapps.homeinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends Base {

    @Builder
    public Item (Long id, String name, Timestamp createdDate, Timestamp lastModifiedDate, Long version,
                 Double cost, String serialNumber, LocalDate purchaseDate, boolean haveReceipt,
                 String additionalInfo, Model itemModel, Owner itemOwner, Category itemCategory,
                 Location itemLocation) {
        super(id, name, createdDate, lastModifiedDate, version);
        this.itemOwner = itemOwner;
        this.itemCategory = itemCategory;
        this.itemLocation = itemLocation;
        this.haveReceipt = haveReceipt;
        this.additionalInfo = additionalInfo;
        this.purchaseDate = purchaseDate;
        this.itemModel = itemModel;
        this.cost = cost;
        this.serialNumber = serialNumber;
    }

    @Column
    private Double cost;

    @Column
    private String serialNumber;

    @Column
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private boolean haveReceipt;

    @Column
    private String additionalInfo;

    @ManyToOne
    private Model itemModel;

    @ManyToOne
    private Category itemCategory;

    @ManyToOne
    private Location itemLocation;

    @ManyToOne
    private Owner itemOwner;
}
