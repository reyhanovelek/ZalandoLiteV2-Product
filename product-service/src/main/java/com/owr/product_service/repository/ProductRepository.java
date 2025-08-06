package com.owr.product_service.repository;

import com.owr.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository handles all database operations for the Product entity.
 * It extends JpaRepository to provide built-in CRUD methods like:
 * - findAll()
 * - findById()
 * - save()
 * - deleteById()
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods (if needed) can be added here
}
