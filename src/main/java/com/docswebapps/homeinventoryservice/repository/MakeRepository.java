package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Make;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MakeRepository extends JpaRepository<Make, Long> {
    Optional<Make> findByName(String name);
}
