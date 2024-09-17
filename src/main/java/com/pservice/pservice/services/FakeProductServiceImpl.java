package com.pservice.pservice.services;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.dtos.MyAppProductDto;
import com.pservice.pservice.exceptions.ProductNotFoundException;
import com.pservice.pservice.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class FakeProductServiceImpl {
    private final RestTemplateBuilder restTemplateBuilder;
    private final String getProductUrl;
    private final String getProductsUrl;
    private final String createProductsUrl;
    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                  @Value("${fakestore.api.products.endpoint}") String fakeStoreProductsEndpoint) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.getProductUrl = fakeStoreApiUrl + fakeStoreProductsEndpoint + "/{id}";
        this.getProductsUrl = fakeStoreApiUrl + fakeStoreProductsEndpoint;
        this.createProductsUrl = fakeStoreApiUrl + fakeStoreProductsEndpoint;
    }

    private static FakeStoreProductDto convertToFakeStoreProductDto(MyAppProductDto myAppProductDto){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(myAppProductDto.getCategory());
        fakeStoreProductDto.setDescription(myAppProductDto.getDescription());
        fakeStoreProductDto.setImage(myAppProductDto.getImage());
        fakeStoreProductDto.setPrice(myAppProductDto.getPrice());
        fakeStoreProductDto.setTitle(myAppProductDto.getTitle());
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto getProductById(Long productId) throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(this.getProductUrl, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Not Found.");
        }
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(this.getProductsUrl, FakeStoreProductDto[].class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }

    public FakeStoreProductDto deleteProductById(Long productId) throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(getProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, productId);
        if (responseEntity != null && responseEntity.getBody() == null) {
            throw new ProductNotFoundException("Not found.");
        }
        assert responseEntity != null;
        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProduct(Long productId, MyAppProductDto myAppProductDto) throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = convertToFakeStoreProductDto(myAppProductDto);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(getProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, productId);
        if (responseEntity != null && responseEntity.getBody() == null) {
            throw new ProductNotFoundException("Not found.");
        }
        assert responseEntity != null;
        return responseEntity.getBody();
    }

    public FakeStoreProductDto createProduct(MyAppProductDto myAppProductDto) throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = convertToFakeStoreProductDto(myAppProductDto);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(createProductsUrl, fakeStoreProductDto, FakeStoreProductDto.class);
        fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Not Found.");
        }
        return fakeStoreProductDto;
    }
}
