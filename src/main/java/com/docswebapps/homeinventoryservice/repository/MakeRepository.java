package com.docswebapps.homeinventoryservice.repository;
import com.docswebapps.homeinventoryservice.domain.Make;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MakeRepository extends PagingAndSortingRepository<Make, Long> {
    Optional<Make> findByName(String name);
}
