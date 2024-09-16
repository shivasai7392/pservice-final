package com.pservice.pservice.services;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.dtos.MyAppProductDto;
import com.pservice.pservice.exceptions.ProductNotFoundException;
import com.pservice.pservice.models.Product;

import java.util.List;

public interface IProductService {
    MyAppProductDto getProductById(Long productId) throws ProductNotFoundException;
    List<MyAppProductDto> getAllProducts();
    MyAppProductDto deleteProductById(Long productId);
    void updateProduct(Product product);
    MyAppProductDto createProduct(MyAppProductDto myAppProductDto);
}
