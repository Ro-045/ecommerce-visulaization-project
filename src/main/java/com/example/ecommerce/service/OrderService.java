package com.example.ecommerce.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.OrdersRepo;


@Service
public class OrderService {
    private final OrdersRepo ordersRepo;
    @Autowired
    public OrderService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    public Orders getOrderById(Long id) {
        return ordersRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Orders createOrder(Orders order) {
        return ordersRepo.save(order);
    }

    public void deleteOrder(Long id) {
        ordersRepo.deleteById(id);
    }
}

