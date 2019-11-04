package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Owner;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long> {
    Optional<Owner> findByName(String name);
}
