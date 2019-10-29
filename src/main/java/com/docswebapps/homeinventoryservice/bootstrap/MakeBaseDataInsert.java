package com.docswebapps.homeinventoryservice.bootstrap;

import com.docswebapps.homeinventoryservice.domain.Make;
import com.docswebapps.homeinventoryservice.repository.MakeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MakeBaseDataInsert implements CommandLineRunner {
    private final MakeRepository makeRepository;

    public MakeBaseDataInsert(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(makeRepository.count() == 0) {
            makeRepository.save(Make.builder().name("Samsung").build());
            makeRepository.save(Make.builder().name("Sony").build());
            makeRepository.save(Make.builder().name("LG").build());
            makeRepository.save(Make.builder().name("Zanussi").build());
            makeRepository.save(Make.builder().name("Motorola").build());
        }
    }
}
