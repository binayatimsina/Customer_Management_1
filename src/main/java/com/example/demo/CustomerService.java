package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private List<Customer> list;

    public CustomerService() {
        list = new ArrayList<Customer>();
        list.add(new Customer(1, "John Doe"));
        list.add(new Customer(2, "Jane Adams"));
        list.add(new Customer(3, "Alice Jones"));

    }

    public List<Customer> getAllCustomers() {
        return this.list;
    }

    public Customer getCustomerByID(long id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == id) {
                return this.list.get(i);
            }
        }
        return null; 
    }

    public void addCustomer(String name) {
        long id = this.list.size() + 1;
        Customer newCustomer = new Customer(id, name);
        this.list.add(newCustomer);
    }

    public void updateCustomer(String newName, long id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == id) {
                this.list.get(i).setName(newName);
            }
        }

    }

    public void deleteCustomer(long id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == id) {
                this.list.remove(i);
            }
        }
    }

    
}
