package com.example.customerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItem {
    private long id;
    private long productId;
    private double unitPrice;
    private int quantity;
    private Product product=new Product();
}
