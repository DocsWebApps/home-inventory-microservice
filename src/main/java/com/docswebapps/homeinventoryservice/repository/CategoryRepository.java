package com.docswebapps.homeinventoryservice.repository;
import com.docswebapps.homeinventoryservice.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
