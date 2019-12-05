package com.docswebapps.homeinventoryservice.bootstrap;
import com.docswebapps.homeinventoryservice.domain.Owner;
import com.docswebapps.homeinventoryservice.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("ownerBaseDataInsert")
@Order(2)
public class OwnerBaseDataInsert implements CommandLineRunner {
    private final OwnerRepository ownerRepository;

    public OwnerBaseDataInsert(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ownerRepository.count() == 0) {
            ownerRepository.save(Owner.builder().name("DAVE").build());
            ownerRepository.save(Owner.builder().name("SARAH").build());
            ownerRepository.save(Owner.builder().name("FRAZER").build());
            ownerRepository.save(Owner.builder().name("JESSICA").build());
        }
    }
}
