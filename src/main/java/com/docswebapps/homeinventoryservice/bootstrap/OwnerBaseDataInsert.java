package com.docswebapps.homeinventoryservice.bootstrap;
import com.docswebapps.homeinventoryservice.domain.Owner;
import com.docswebapps.homeinventoryservice.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class OwnerBaseDataInsert implements CommandLineRunner {
    private final OwnerRepository ownerRepository;

    public OwnerBaseDataInsert(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(ownerRepository.count() == 0) {
            ownerRepository.save(Owner.builder().name("Dave").build());
            ownerRepository.save(Owner.builder().name("Sarah").build());
            ownerRepository.save(Owner.builder().name("Frazer").build());
            ownerRepository.save(Owner.builder().name("Jessica").build());
        }
    }
}
