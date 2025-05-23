package com.example.inventoryservice.service;

import com.example.inventoryservice.dao.ProductDao;
import com.example.inventoryservice.model.Entity.Product;
import com.example.inventoryservice.model.dto.ProductDto;
import com.example.inventoryservice.model.mapper.ProductMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final ProductMap productMap;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMap.toProduct(productDto);
        return productMap.toProductDto(productDao.createProduct(product));
    }

    @Override
    public long countProducts() {
        return productDao.countProducts();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productDao.getAllProducts().stream().map(productMap::toProductDto).toList();
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {
        return productDao.getProductById(id).map(productMap::toProductDto);
    }
}
