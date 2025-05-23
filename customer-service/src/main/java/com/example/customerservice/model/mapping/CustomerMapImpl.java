package com.example.customerservice.model.mapping;

import com.example.customerservice.model.dto.CustomerDto;
import com.example.customerservice.model.entity.Customer;
import org.springframework.stereotype.Service;


@Service
public class CustomerMapImpl implements CustomerMap {
    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .command_id(customerDto.getCommand_id())
                .commands(customerDto.getCommands())
                .build();
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .commands(customer.getCommands())
                .command_id(customer.getCommand_id())
                .build();
    }
}
