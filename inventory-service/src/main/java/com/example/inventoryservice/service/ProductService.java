package com.example.inventoryservice.service;

import com.example.inventoryservice.dao.ProductDao;
import com.example.inventoryservice.model.Entity.Product;
import com.example.inventoryservice.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {


    ProductDto createProduct(ProductDto productDto);

    long countProducts();

    List<ProductDto> getAllProducts();


    Optional<ProductDto> getProductById(Long id);


}
