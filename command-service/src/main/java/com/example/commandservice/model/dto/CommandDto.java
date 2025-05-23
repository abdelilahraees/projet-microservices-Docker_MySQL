package com.example.commandservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandDto {
    private long id;
    private String description;
    private String command;
    private LocalDateTime createdAt;
    private long customer_id;
    private double total_price;
    private CustomerDto customer;
    private List<ProductItemDto> productItem;

    public CommandDto(String description, String command, long customer_id, double total_price) {
        this.description = description;
        this.command = command;
        this.customer_id = customer_id;
        this.total_price = total_price;
    }
}
