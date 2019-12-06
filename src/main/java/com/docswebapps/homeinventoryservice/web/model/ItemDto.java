package com.docswebapps.homeinventoryservice.web.model;

import com.docswebapps.homeinventoryservice.domain.Category;
import com.docswebapps.homeinventoryservice.domain.Location;
import com.docswebapps.homeinventoryservice.domain.Model;
import com.docswebapps.homeinventoryservice.domain.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto extends BaseDto {
    private String itemModel;
    private String itemCategory;
    private String itemLocation;
    private String itemOwner;
    private Double cost;
    private String serialNumber;
    private LocalDate purchaseDate;
    private boolean haveReceipt;
    private String additionalInfo;

    @Builder
    public ItemDto(Long id, String name, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate,
                   Model itemModel, Category itemCategory, Owner itemOwner, Location itemLocation, Double cost, boolean haveReceipt,
                   String additionalInfo, LocalDate purchaseDate, String serialNumber) {
        super(id, name, createdDate, lastModifiedDate);
        this.additionalInfo = additionalInfo;
        this.itemCategory = itemCategory.getName();
        this.itemLocation = itemLocation.getName();
        this.itemOwner = itemOwner.getName();
        this.itemModel = itemModel.getName();
        this.cost = cost;
        this.haveReceipt = haveReceipt;
        this.purchaseDate = purchaseDate;
        this.serialNumber = serialNumber;
    }

}
