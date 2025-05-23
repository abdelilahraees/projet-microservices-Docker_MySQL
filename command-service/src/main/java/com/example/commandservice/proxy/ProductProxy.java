package com.example.commandservice.proxy;

import com.example.commandservice.model.dto.ProductDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "inventory-service")
public interface ProductProxy {
    @CircuitBreaker(name = "getProduct", fallbackMethod = "getProductfallback")
    @GetMapping("/getProduct")
    public Optional<ProductDto> getProduct(@RequestParam Long id);


    default Optional<ProductDto> getProductfallback(Long id, Exception e) {
        return
                Optional.of(new ProductDto("product_not-exist", "product_not-exist", 0, 0));
    }

}
