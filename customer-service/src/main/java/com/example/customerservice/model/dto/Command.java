package com.example.customerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Command {
    private Long id;
    private String description;
    private String command;
    private LocalDateTime createdAt;
    private long customer_id;
    private double total_price;
    private List<ProductItem> productItem=new ArrayList<>();


}
