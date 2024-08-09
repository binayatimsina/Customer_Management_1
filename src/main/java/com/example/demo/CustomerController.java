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
        return customerService.getCustomerByID(id).get();
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody Map<String, String> body) {
        System.out.println(body);
        String name = body.get("name");
        return customerService.addCustomer(name); 
    }

    @PutMapping("/{id}")
    public Customer updateCustomerList(@RequestBody Map<String, String> body, @PathVariable Long id) {
        String updatedName = body.get("name");
        return customerService.updateCustomer(updatedName, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

    @PostMapping("/purchase/{id}")
    public void purchase(@RequestBody Map<String, Double> body, @PathVariable Long id) {
        System.out.println("INSIDE PURCHASE");
        double purchaseAmount = body.get("totalAmount");
        customerService.purchase(purchaseAmount, id);
    }

    @PostMapping("/purchasewithcredit/{id}")
    public void purchaseWithCredit(@RequestBody Map<String, Double> body, @PathVariable Long id) {
        System.out.println("INSIDE PURCHASE WITH CREDIT");
        double purchaseAmount = body.get("totalAmount");
        customerService.purchaseWithCredit(purchaseAmount, id);
    }

    @PostMapping("/payment/{id}")
    public void makePayment(@RequestBody Map<String, Double> body, @PathVariable Long id) {
        double payment = body.get("totalPayment");
        customerService.makePayment(payment, id);
    }
}
