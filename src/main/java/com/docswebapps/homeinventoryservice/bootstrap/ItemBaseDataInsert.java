package com.docswebapps.homeinventoryservice.bootstrap;

import com.docswebapps.homeinventoryservice.domain.*;
import com.docswebapps.homeinventoryservice.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component("itemDataInsert")
@Order(3)
public class ItemBaseDataInsert implements CommandLineRunner {
    private final OwnerRepository ownerRepository;
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;
    private final ModelRepository modelRepository;
    private final ItemRepository itemRepository;

    public ItemBaseDataInsert(OwnerRepository ownerRepository,
                              LocationRepository locationRepository,
                              CategoryRepository categoryRepository,
                              ModelRepository modelRepository,
                              ItemRepository itemRepository) {
        this.ownerRepository = ownerRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
        this.modelRepository = modelRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<Owner> owner = this.ownerRepository.findByName("Dave");
        Optional<Category> category = this.categoryRepository.findByName("Electronic");
        Optional<Location> location = this.locationRepository.findByName("Living Room");
        Optional<Model> model = this.modelRepository.findByName("S5");

        if(owner.isPresent() && location.isPresent() && category.isPresent() && model.isPresent() && this.itemRepository.count() == 0) {
            this.itemRepository.save(Item.builder()
                    .additionalInfo("AdditionalInfo")
                    .cost(399.99d)
                    .haveReceipt(false)
                    .serialNumber("A5N")
                    .purchaseDate(LocalDate.now())
                    .itemOwner(owner.get())
                    .itemCategory(category.get())
                    .itemModel(model.get())
                    .itemLocation(location.get())
                    .build());
        }
    }
}
