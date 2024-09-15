package com.pservice.pservice.controllers;

import com.pservice.pservice.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public void getAllProducts() {}

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Product with ids" + id;
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {}

//    public void updateProductById() {}
//
//    public void createProduct() {}
}
