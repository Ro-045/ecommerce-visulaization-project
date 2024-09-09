package com.example.ecommerce.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import  com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.ChartDataRepo;
import com.example.ecommerce.service.CustomerService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
private ChartDataRepo chartDataRepo;
private CustomerService customerService;

 @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

@GetMapping("/chart-data")
public Map<String, Object> getCustomersChartData() {
    List<Customers> customers = customerService.getAllCustomers();

    // Create a map to store the count of customers per month
    Map<String, Integer> monthlyCounts = new TreeMap<>();
    for (Customers customer : customers) {
        String month = customer.getCreatedAt().getMonth().toString(); // Assuming getCreatedAt() returns a LocalDateTime
        monthlyCounts.put(month, monthlyCounts.getOrDefault(month, 0) + 1);
    }

    // Convert the map to ChartData entity
    ChartData chartDataEntity = new ChartData(
        new ArrayList<>(monthlyCounts.keySet()), 
        new ArrayList<>(monthlyCounts.values())
    );

    // Save the chart data to the database
    chartDataRepo.save(chartDataEntity);

    // Prepare the data for the chart to return as a response
    Map<String, Object> chartData = new HashMap<>();
    chartData.put("labels", chartDataEntity.getLabels());
    chartData.put("values", chartDataEntity.getValues());

    return chartData;
}


@GetMapping("/stored-chart-data/{id}")
public ChartData getStoredChartData(@PathVariable Long id) {
    return chartDataRepo.findById(id).orElse(null);
}





    @GetMapping("/{id}")
    public Customers getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers) {
        Customers createdCustomer=customerService.createCustomer(customers);
        return new ResponseEntity<>(createdCustomer,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
    
    
}
