package com.pservice.pservice.controllers;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.dtos.MyAppProductDto;
import com.pservice.pservice.exceptions.ProductNotFoundException;
import com.pservice.pservice.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<MyAppProductDto> getAllProducts() throws ProductNotFoundException  {
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public MyAppProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return this.productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public MyAppProductDto deleteProductById(@PathVariable("id") Long id) throws ProductNotFoundException  {
        return this.productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public MyAppProductDto updateProductById(@PathVariable("id") Long id, @RequestBody MyAppProductDto myAppRequestProductDto) throws ProductNotFoundException {
        return this.productService.updateProduct(id, myAppRequestProductDto);
    }

    @PostMapping
    public MyAppProductDto createProduct(@RequestBody MyAppProductDto myAppRequestProductDto)  throws ProductNotFoundException {
        return this.productService.createProduct(myAppRequestProductDto);
    }
}
