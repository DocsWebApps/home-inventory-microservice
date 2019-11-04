package com.docswebapps.homeinventoryservice.bootstrap;

import com.docswebapps.homeinventoryservice.domain.Make;
import com.docswebapps.homeinventoryservice.domain.Model;
import com.docswebapps.homeinventoryservice.repository.MakeRepository;
import com.docswebapps.homeinventoryservice.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class ModelBaseDataInsert implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final MakeRepository makeRepository;

    public ModelBaseDataInsert(ModelRepository modelRepository, MakeRepository makeRepository) {
        this.modelRepository = modelRepository;
        this.makeRepository = makeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Make samsung = makeRepository.findByName("Samsung");
        if(modelRepository.count() == 0) {
            modelRepository.save(Model.builder().name("S5").modelMake(samsung).build());
            modelRepository.save(Model.builder().name("S6").modelMake(samsung).build());
            modelRepository.save(Model.builder().name("S8").modelMake(samsung).build());
            modelRepository.save(Model.builder().name("S10").modelMake(samsung).build());
        }
    }
}
