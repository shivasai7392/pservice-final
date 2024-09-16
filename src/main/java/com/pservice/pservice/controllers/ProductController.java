package com.pservice.pservice.controllers;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public void getAllProducts() {}

    @GetMapping("/{id}")
    public FakeStoreProductDto getProductById(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {}

//    public void updateProductById() {}
//
//    public void createProduct() {}
}
