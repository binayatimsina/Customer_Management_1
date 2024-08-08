package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private double total_sales;
    private double balance_due;


    public Customer() {
    }

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
        this.total_sales = 0.0;
        this.balance_due = 0.0;
    }

    public long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getTotalSales() {
        return this.total_sales;
    }

    public void setTotalSales(double totalSales) {
        this.total_sales = totalSales;
    }

    public double getBalanceDue() {
        return this.balance_due;
    }

    public void setBalanceDue(double balanceDue) {
        this.balance_due = balanceDue;
    }
 }
