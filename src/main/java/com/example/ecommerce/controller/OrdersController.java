package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import  com.example.ecommerce.entity.*;
import com.example.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getAllOrders(){
       List<Orders> orders=orderService.getAllOrders();
       return orders;
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        Orders createdProduct=orderService.createOrder(orders);
        return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
    
    
}

