package com.pservice.pservice;

import com.pservice.pservice.models.Category;
import com.pservice.pservice.models.Product;
import com.pservice.pservice.repositories.CategoryRepository;
import com.pservice.pservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class PServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public PServiceApplication(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        Category category = new Category();
//        category.setName("Apple Products");
//        categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setCategory(category);
//        product.setTitle("IPhone 16");
//        product.setDescription("IPhone 16 Apple Products");
//        product.setPrice(15000.0);
//        productRepository.save(product);
//        Optional<Category> optionalCategory = this.categoryRepository.findById(UUID.fromString("1d098a7c-e46e-43fd-8a48-da6cbdb4486a"));
//        Category category = null;
//        if (optionalCategory.isPresent()) {
//            category = optionalCategory.get();
//        }
//        System.out.println(category.getProducts());
    }
}
