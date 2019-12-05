package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Optional<Model> findByName(String name);
}
