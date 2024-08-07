package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}") 
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerByID(id);
    }

    @PostMapping("")
    public void createCustomer(@RequestBody Map<String, String> body) {
        System.out.println(body);
        String name = body.get("name");
        customerService.addCustomer(name); 
    }

    @PutMapping("/{id}")
    public void updateCustomerList(@RequestBody Map<String, String> body, @PathVariable Long id) {
        String updatedName = body.get("name");
        customerService.updateCustomer(updatedName, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
