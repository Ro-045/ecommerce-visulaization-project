package com.example.ecommerce.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Long id;
    private Long customer_id;
    private BigDecimal total_price;
    private LocalDateTime orderd_at;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }
    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }
    
    public LocalDateTime getOrderd_at() {
        return orderd_at;
    }
    public void setOrderd_at(LocalDateTime orderd_at) {
        this.orderd_at = orderd_at;
    }


    
}