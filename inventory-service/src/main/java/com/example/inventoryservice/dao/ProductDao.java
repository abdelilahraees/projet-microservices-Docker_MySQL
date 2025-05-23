package com.example.inventoryservice.dao;

import com.example.inventoryservice.model.Entity.Product;
import com.example.inventoryservice.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDao {
    private final ProductRepo productRepo;
    public Long countProducts() {
        return productRepo.count();
    }


    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }



}
