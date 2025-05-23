package com.example.inventoryservice.web;

import com.example.inventoryservice.model.Entity.Product;
import com.example.inventoryservice.model.dto.ProductDto;
import com.example.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProduct")
    public Optional<ProductDto> getProduct(@RequestParam Long id) {
        return productService.getProductById(id);

    }


}
