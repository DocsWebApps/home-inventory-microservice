package com.docswebapps.homeinventoryservice.bootstrap;
import com.docswebapps.homeinventoryservice.domain.Owner;
import com.docswebapps.homeinventoryservice.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OwnerBaseDataInsert implements CommandLineRunner {
    private final OwnerRepository ownerRepository;

    public OwnerBaseDataInsert(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(ownerRepository.count() == 0) {
            ownerRepository.save(Owner.builder().firstName("Dave").lastName("Collier").build());
            ownerRepository.save(Owner.builder().firstName("Sarah").lastName("Collier").build());
            ownerRepository.save(Owner.builder().firstName("Frazer").lastName("Collier").build());
            ownerRepository.save(Owner.builder().firstName("Jessica").lastName("Collier").build());
        }
    }
}
