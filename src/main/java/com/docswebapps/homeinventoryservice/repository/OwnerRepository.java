package com.docswebapps.homeinventoryservice.repository;

import com.docswebapps.homeinventoryservice.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByName(String name);
}
