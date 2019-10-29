package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Model;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {
}
