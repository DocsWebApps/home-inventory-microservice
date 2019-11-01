package com.docswebapps.homeinventoryservice.domain;
import java.sql.Timestamp;
import java.time.LocalDate;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "items")
public class Item {
    private Double cost;
    private String serialNumber;
    private LocalDate purchaseDate;
    private boolean estimatedDate;
    private boolean haveReceipt;
    private String additionalInfo;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
}
