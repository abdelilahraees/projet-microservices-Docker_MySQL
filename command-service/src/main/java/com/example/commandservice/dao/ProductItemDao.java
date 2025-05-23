package com.example.commandservice.dao;

import com.example.commandservice.Repository.ProductItemRepo;
import com.example.commandservice.model.entity.ProductItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductItemDao {

    private final ProductItemRepo productItemRepo;


    public ProductItem productItem(ProductItem cart) {
        return productItemRepo.save(cart);
    }

    public List<ProductItem> findByCommandId(Long command_id) {
        return productItemRepo.findByCommandId(command_id);

    }

}
