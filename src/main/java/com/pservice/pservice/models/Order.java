package com.pservice.pservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity(name = "orders")
public class Order extends BaseModel{
    @ManyToMany
    private List<Product> products;
}
