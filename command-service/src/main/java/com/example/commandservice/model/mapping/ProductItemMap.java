package com.example.commandservice.model.mapping;

import com.example.commandservice.model.dto.ProductItemDto;
import com.example.commandservice.model.entity.ProductItem;
import org.springframework.stereotype.Service;

@Service
public class ProductItemMap {
   public ProductItemDto toProductItemDto(ProductItem cart) {
        return ProductItemDto.builder()
                .id(cart.getId())
                .productId(cart.getProductId())
                .unitPrice(cart.getUnitPrice())
                .quantity(cart.getQuantity())
                .build();

    }

   public ProductItem toProductItem(ProductItemDto cart) {
        return ProductItem.builder()
                .id(cart.getId())
                .productId(cart.getProductId())
                .unitPrice(cart.getUnitPrice())
                .quantity(cart.getQuantity())
                .build();

    }

}
