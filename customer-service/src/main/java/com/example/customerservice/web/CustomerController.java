package com.example.customerservice.web;

import com.example.customerservice.model.dto.CustomerDto;
import com.example.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;


    @GetMapping("/getCustomerById")
    private Optional<CustomerDto> getCustomer(@RequestParam long id) {
        System.out.println(id);
        return customerService.getCustomerById(id);
    }

    @PostMapping("/createCustomer")
    private CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.createCustomer(customerDto);
    }

    @DeleteMapping("/deleteCustomer")
    private boolean deleteCustomer(@RequestParam long id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/getAllCustomers")
    private List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/updateCustomer")
    private CustomerDto updateCustomer(@RequestParam long id, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(id, customerDto);
    }

}
