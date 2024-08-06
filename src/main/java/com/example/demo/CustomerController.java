package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired public CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("") 
    public Customer getCustomerById(@RequestParam Long id) {
        return customerService.getCustomerByID(id);
    }

    @PostMapping("/createCustomer")
    public List<Customer> createCustomer(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        customerService.addCustomer(name);
        return getAllCustomers(); 
    }

    @PutMapping("")
    public List<Customer> updateCustomerList() {
        
    }
}
