package com.example.customerservice.model.mapping;

import com.example.customerservice.model.dto.CustomerDto;
import com.example.customerservice.model.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerMap {

    Customer toCustomer(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);
}
