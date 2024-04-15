package org.utech.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utech.productservice.models.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByTitle(String title);
}
