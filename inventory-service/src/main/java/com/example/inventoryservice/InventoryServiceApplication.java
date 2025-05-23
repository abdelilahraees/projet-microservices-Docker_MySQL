package com.example.inventoryservice;

import com.example.inventoryservice.model.dto.ProductDto;
import com.example.inventoryservice.service.ProductService;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            if (productService.countProducts() == 0) {
                for (int i = 0; i < 20; i++) {
                    productService.createProduct(new ProductDto("product" + i, "description" + i, 100, 200));
                    System.out.println("product" + i+" created");
                }
            }

        };
    }

}
