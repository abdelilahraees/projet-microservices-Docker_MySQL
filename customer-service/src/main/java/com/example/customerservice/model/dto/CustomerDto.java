package com.example.customerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class CustomerDto {
    private long id;
    private String name;
    private String email;
    private long command_id;

    private List<Command> commands;

    public CustomerDto(String name, String email,long command_id) {
        this.name = name;
        this.email = email;
        this.command_id = command_id;

    }


    public CustomerDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
