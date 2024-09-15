package com.pservice.pservice.services;

import com.pservice.pservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService {

    @Override
    public String getProductById(Long productId) {
        return "";
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById(Long productId) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void createProduct(Product product) {

    }
}
