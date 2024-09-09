package com.example.ecommerce.repository;
import com.example.ecommerce.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {
}

