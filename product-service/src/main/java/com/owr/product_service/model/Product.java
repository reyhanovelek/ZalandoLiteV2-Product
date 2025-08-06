package com.owr.product_service.model;

import jakarta.persistence.*;

/**
 * Product entity class represents the product details stored in the database.
 * Each instance of this class corresponds to a row in the 'product' table.
 */
@Entity
public class Product {

    // Unique identifier for the product
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the product
    private String name;

    // Product category (e.g., Shoes, Shirts, etc.)
    private String category;

    // Price of the product in decimal format
    private Double price;

    /**
     * Default constructor for JPA
     */
    public Product() {
    }

    /**
     * All-arguments constructor
     */
    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and Setters for all fields below

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
