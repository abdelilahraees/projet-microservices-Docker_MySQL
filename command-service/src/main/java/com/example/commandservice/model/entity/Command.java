package com.example.commandservice.model.entity;


import com.example.commandservice.model.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String command;
    @OneToMany(orphanRemoval = true,mappedBy = "command")
    private List<ProductItem> productItem=new ArrayList<>();
    @CreatedDate
    private LocalDateTime createdAt;
    private String description;
    private long customerId;
    private double total_price;
    @Transient
    private CustomerDto customerDto;
}
