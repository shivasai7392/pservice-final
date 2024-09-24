package com.pservice.pservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;
    private double price;
}
