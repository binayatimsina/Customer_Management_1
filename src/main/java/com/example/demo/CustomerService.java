package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> list;

    public CustomerService() {
        list = new ArrayList<>();
        list.add(new Customer(1, "John Doe"));
        list.add(new Customer(2, "Jane Adams"));
        list.add(new Customer(3, "Alice Jones"));

    }

    
}
