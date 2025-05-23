package com.example.inventoryservice.model.mapper;

import com.example.inventoryservice.model.Entity.Product;
import com.example.inventoryservice.model.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class ProductMap {

    public Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

    }

    public ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .name(product.getName())
                .description(product.getDescription())
                .build();


    }
}