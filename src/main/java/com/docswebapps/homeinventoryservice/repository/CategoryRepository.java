package com.docswebapps.homeinventoryservice.repository;
import com.docswebapps.homeinventoryservice.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
