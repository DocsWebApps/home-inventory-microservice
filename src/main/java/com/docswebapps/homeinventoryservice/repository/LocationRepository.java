package com.docswebapps.homeinventoryservice.repository;
import com.docswebapps.homeinventoryservice.domain.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {
}
