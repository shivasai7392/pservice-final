package com.pservice.pservice.services;

import com.pservice.pservice.models.Product;

public interface IProductService {
    String getProductById(Long productId);
    void getAllProducts();
    void deleteProductById(Long productId);
    void updateProduct(Product product);
    void createProduct(Product product);
}
