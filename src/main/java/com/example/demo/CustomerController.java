package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired public CustomerService customerService;

    @GetMapping("")
    public String customer() {
        return "Welcome to Customer Management API";
    }

    @GetMapping("/allCustomers") 
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/createCustomer")
    public List<Customer> createCustomer(@RequestBody String name) {

        customerService.addCustomer(name);
        return getAllCustomers(); 
    }
}
