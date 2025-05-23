package com.example.customerservice.service;

import com.example.customerservice.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CustomerService {


    CustomerDto createCustomer(CustomerDto customerDto);

    Optional<CustomerDto> getCustomerById(long id);

    CustomerDto updateCustomer(long id, CustomerDto customerDto);

    boolean deleteCustomer(long id);

    List<CustomerDto> getAllCustomers();

    boolean customerExists(Long id);



}
