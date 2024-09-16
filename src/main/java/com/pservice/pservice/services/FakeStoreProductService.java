package com.pservice.pservice.services;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements IProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductUrl = "https://fakestoreapi.com/products/{id}";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public FakeStoreProductDto getProductById(Long productId) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(this.getProductUrl, FakeStoreProductDto.class, productId);
        return responseEntity.getBody();
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
