package com.docswebapps.homeinventoryservice.bootstrap;

import com.docswebapps.homeinventoryservice.domain.Make;
import com.docswebapps.homeinventoryservice.repository.MakeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("makeBaseDataInsert")
@Order(1)
public class MakeBaseDataInsert implements CommandLineRunner {
    private final MakeRepository makeRepository;

    public MakeBaseDataInsert(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (makeRepository.count() == 0) {
            makeRepository.save(Make.builder().name("SAMSUNG").build());
            makeRepository.save(Make.builder().name("SONY").build());
            makeRepository.save(Make.builder().name("LG").build());
            makeRepository.save(Make.builder().name("ZANUSSI").build());
            makeRepository.save(Make.builder().name("MOTOROLA").build());
        }
    }
}
