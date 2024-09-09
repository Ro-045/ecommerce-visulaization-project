package com.example.ecommerce.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.entity.Customers;
import com.example.ecommerce.repository.CustomersRepo;


@Service
public class CustomerService {
    private final CustomersRepo customersRepo;

    @Autowired
    public CustomerService(CustomersRepo customersRepo) {
        this.customersRepo = customersRepo;
    }

    public List<Customers> getAllCustomers() {
        return customersRepo.findAll();
    }

    public Customers getCustomerById(Long id) {
        return customersRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customers createCustomer(Customers customer) {
        return customersRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customersRepo.deleteById(id);
    }
}

