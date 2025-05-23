package com.example.commandservice.Repository;

import com.example.commandservice.model.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByCommandId(Long command_id);
}
