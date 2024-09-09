package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ChartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartDataRepo extends JpaRepository<ChartData, Long> {
}

