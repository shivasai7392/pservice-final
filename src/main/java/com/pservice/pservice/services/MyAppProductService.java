package com.pservice.pservice.services;

import com.pservice.pservice.dtos.FakeStoreProductDto;
import com.pservice.pservice.dtos.MyAppProductDto;
import com.pservice.pservice.exceptions.ProductNotFoundException;
import com.pservice.pservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("FakeStoreProductService")
public class MyAppProductService implements IProductService{

    private final FakeProductServiceImpl fakeProductService;
    public MyAppProductService(FakeProductServiceImpl fakeProductService) {
        this.fakeProductService = fakeProductService;
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
    public MyAppProductDto getProductById(Long productId) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = this.fakeProductService.getProductById(productId);
        return convertToMyAppProductDto(fakeStoreProductDto);
    }

    @Override
    public List<MyAppProductDto> getAllProducts()  throws ProductNotFoundException {
        List<FakeStoreProductDto> fakeStoreProductDtos = this.fakeProductService.getAllProducts();
        List<MyAppProductDto> myAppProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            myAppProductDtos.add(convertToMyAppProductDto(fakeStoreProductDto));
        }
        return myAppProductDtos;
    }

    @Override
    public MyAppProductDto deleteProductById(Long productId) throws ProductNotFoundException  {
       FakeStoreProductDto fakeStoreProductDto = this.fakeProductService.deleteProductById(productId);
       return convertToMyAppProductDto(fakeStoreProductDto);
    }

    @Override
    public MyAppProductDto updateProduct(Long productId, MyAppProductDto myAppProductDto) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = this.fakeProductService.updateProduct(productId, myAppProductDto);
        return convertToMyAppProductDto(fakeStoreProductDto);
    }

    @Override
    public MyAppProductDto createProduct(MyAppProductDto myAppRequestProductDto) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = this.fakeProductService.createProduct(myAppRequestProductDto);
        return convertToMyAppProductDto(fakeStoreProductDto);
    }
}
