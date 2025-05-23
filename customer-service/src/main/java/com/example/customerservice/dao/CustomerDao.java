package com.example.customerservice.dao;

import com.example.customerservice.model.entity.Customer;
import com.example.customerservice.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDao {
    private final CustomerRepo customerRepository;


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


    public boolean CustomerExists(Long id) {
        return customerRepository.existsById(id);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Long id, Customer customer) {
        return customerRepository.save(customer);
    }





}
