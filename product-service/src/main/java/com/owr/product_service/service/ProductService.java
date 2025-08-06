package com.owr.product_service.service;

import com.owr.product_service.model.Product;
import com.owr.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer that contains the business logic related to Product operations.
 * It interacts with the ProductRepository to perform database actions.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor injection of ProductRepository
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves all products from the database.
     *
     * @return list of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a single product by its ID.
     *
     * @param id product ID
     * @return Optional containing the product or empty if not found
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Save a new product in the database
     *
     * @param product the product entity to save
     * @return the saved product
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    /**
     * Updates an existing product (if it exists).
     * Update a product by ID
     *
     * @param id      the product ID
     * @param product the updated product data
     * @return Optional containing updated product, or empty if not found
     */
    public Optional<Product> updateProduct(Long id, Product product) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(product.getName());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        });
    }


    /**
     * Delete a product by ID
     *
     * @param id the product ID
     * @return true if product was deleted, false if not found
     */
    public boolean deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}