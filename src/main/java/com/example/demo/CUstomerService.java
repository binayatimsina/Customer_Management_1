package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CUstomerService {
    private List<Customer> list;

    public CUstomerService() {
        list = new ArrayList<>();
        list.add(new Customer(1, "John Doe"));
        list.add(new Customer(2, "Jane Adams"));
        list.add(new Customer(3, "Alice Jones"));

    }

    
}
