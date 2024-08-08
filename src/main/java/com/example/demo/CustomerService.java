package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    private List<Customer> list;

    @Autowired
    private CustomerRepository customerRepository;

    // public CustomerService() {
    //     list = new ArrayList<Customer>();
    //     list.add(new Customer(1, "John Doe"));
    //     list.add(new Customer(2, "Jane Adams"));
    //     list.add(new Customer(3, "Alice Jones"));

    // }

    public List<Customer> getAllCustomers() {
        // return this.list;
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByID(long id) {
        // for (int i = 0; i < this.list.size(); i++) {
        //     if (this.list.get(i).getId() == id) {
        //         return this.list.get(i);
        //     }
        // }
        // return null; 
        return customerRepository.findById(id);
    }

    public Customer addCustomer(String name) {
        // long id = this.list.size() + 1;
        // Customer newCustomer = new Customer(id, name);
        // this.list.add(newCustomer);
        Customer customer = new Customer(customerRepository.count()+1, name);

        return customerRepository.save(customer);
        // return customer;
    }

    public void updateCustomer(String newName, long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer != null) {
            customer.setName(newName);
            customerRepository.save(customer);
        }

    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    public void purchase(double purchaseAmount, long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer != null) {
            customer.setTotalSales(customer.getTotalSales() + purchaseAmount);
            customerRepository.save(customer);
        }
    }

    @Transactional
    public void purchaseWithCredit(double purchaseAmount, long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer != null) {
            customer.setTotalSales(customer.getTotalSales() + purchaseAmount);
            customer.setBalanceDue(customer.getBalanceDue() + purchaseAmount);
            customerRepository.save(customer);
        }
    }

    @Transactional
    public void makePayment(double payment, long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer != null) {
            customer.setBalanceDue(customer.getBalanceDue() - payment);
            customerRepository.save(customer);
        }   
    }


    
}
