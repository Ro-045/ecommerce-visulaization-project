package com.example.ecommerce.service;
import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.ProductsRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductsRepo productsRepo;
    @Autowired
    public ProductService(ProductsRepo productsRepo){
        this.productsRepo=productsRepo;
    }

    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    public Products getProductById(Long id) {
        return productsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Products createProduct(Products product) {
        return productsRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productsRepo.deleteById(id);
    }
    
}

