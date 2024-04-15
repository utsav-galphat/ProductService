package org.utech.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utech.productservice.models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    Optional<Product> findById(UUID uuid);

    List<Product> findAll();

    Optional<Product> findByTitle(String title);
}
