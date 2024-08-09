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


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByID(long id) {
        return customerRepository.findById(id);
    }

    public Customer addCustomer(String name) {
        Customer customer = new Customer(customerRepository.count()+1, name);

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String newName, long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer != null) {
            customer.setName(newName);
            return customerRepository.save(customer);
        }
        return null;

    }

    public boolean deleteCustomer(long id) {
        customerRepository.deleteById(id);
        if (customerRepository.findById(id) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Customer purchase(double purchaseAmount, long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer != null) {
            customer.setTotalSales(customer.getTotalSales() + purchaseAmount);
            return customerRepository.save(customer);
        }
        return null;
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
