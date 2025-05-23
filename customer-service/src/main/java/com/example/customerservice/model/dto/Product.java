package com.example.customerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private long quantity;
}
