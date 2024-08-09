package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;

    @Column(name = "total_sales")
    private double totalSales;

    @Column(name = "balance_due")
    private double balanceDue;


    public Customer() {
    }

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
        this.totalSales = 0.0;
        this.balanceDue = 0.0;
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
        return this.totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getBalanceDue() {
        return this.balanceDue;
    }

    public void setBalanceDue(double balanceDue) {
        this.balanceDue = balanceDue;
    }
 }
