package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Model;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {
    Optional<Model> findByName(String name);
}
