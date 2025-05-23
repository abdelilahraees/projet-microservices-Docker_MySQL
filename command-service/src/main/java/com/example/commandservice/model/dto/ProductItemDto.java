package com.example.commandservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItemDto {
    private long id;
    private long productId;
    private double unitPrice;
    private int quantity;
    private ProductDto product;
}
