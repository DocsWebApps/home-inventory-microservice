package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Owner;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long> {
}
