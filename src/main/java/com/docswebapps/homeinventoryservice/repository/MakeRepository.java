package com.docswebapps.homeinventoryservice.repository;
import com.docswebapps.homeinventoryservice.domain.Make;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MakeRepository extends PagingAndSortingRepository<Make, Long> {
    public Make findByName(String name);
}
