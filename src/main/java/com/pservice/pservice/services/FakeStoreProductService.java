package com.pservice.pservice.services;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.dtos.MyAppProductDto;
import com.pservice.pservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements IProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductUrl = "https://fakestoreapi.com/products/{id}";
    private String getProductsUrl = "https://fakestoreapi.com/products";
    private String createProductsUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static MyAppProductDto convertToMyAppProductDto(FakeStoreProductDto fakeStoreProductDto){
        MyAppProductDto myAppProductDto = new MyAppProductDto();
        myAppProductDto.setId(fakeStoreProductDto.getId());
        myAppProductDto.setTitle(fakeStoreProductDto.getTitle());
        myAppProductDto.setDescription(fakeStoreProductDto.getDescription());
        myAppProductDto.setImage(fakeStoreProductDto.getImage());
        myAppProductDto.setPrice(fakeStoreProductDto.getPrice());
        myAppProductDto.setCategory(fakeStoreProductDto.getCategory());
        return myAppProductDto;
    }

    @Override
    public MyAppProductDto getProductById(Long productId) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(this.getProductUrl, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        assert fakeStoreProductDto != null;
        return convertToMyAppProductDto(fakeStoreProductDto);
    }

    @Override
    public List<MyAppProductDto> getAllProducts() {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(this.getProductsUrl, FakeStoreProductDto[].class);
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(Objects.requireNonNull(responseEntity.getBody()));
        List<MyAppProductDto> myAppProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            myAppProductDtos.add(convertToMyAppProductDto(fakeStoreProductDto));
        }
        return myAppProductDtos;
    }

    @Override
    public void deleteProductById(Long productId) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public MyAppProductDto createProduct(MyAppProductDto myAppRequestProductDto) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(createProductsUrl, myAppRequestProductDto, FakeStoreProductDto.class);
        return convertToMyAppProductDto(Objects.requireNonNull(responseEntity.getBody()));
    }
}
