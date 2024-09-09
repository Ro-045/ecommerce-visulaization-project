package com.example.ecommerce.entity;
import java.math.BigDecimal;

import jakarta.persistence.*;
@Entity
public class Products {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private BigDecimal price;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }  
    
}
