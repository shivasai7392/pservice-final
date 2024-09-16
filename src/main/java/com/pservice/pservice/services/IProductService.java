package com.pservice.pservice.services;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.dtos.MyAppProductDto;
import com.pservice.pservice.models.Product;

public interface IProductService {
    MyAppProductDto getProductById(Long productId);
    void getAllProducts();
    void deleteProductById(Long productId);
    void updateProduct(Product product);
    void createProduct(Product product);
}
