package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Customers;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Long> {
}
