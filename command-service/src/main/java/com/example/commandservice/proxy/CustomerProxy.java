package com.example.commandservice.proxy;

import com.example.commandservice.model.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Service
@FeignClient(name = "customer-service")
public interface CustomerProxy {

    @DeleteMapping("/deleteCustomer")
    public boolean deleteCustomer(@RequestParam Long id);

    @GetMapping("/getCustomerById")
    public Optional<CustomerDto> getCustomer(@RequestParam Long id);

    @PostMapping("/createCustomer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto);

}
