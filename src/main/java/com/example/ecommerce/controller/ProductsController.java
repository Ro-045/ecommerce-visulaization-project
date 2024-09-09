package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import  com.example.ecommerce.entity.*;
import com.example.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getAllProducts(){
       List<Products> products=productService.getAllProducts();
       return products;
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products products) {
        Products createdProduct=productService.createProduct(products);
        return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    
    
}

