package com.example.customerservice;

import com.example.customerservice.model.dto.CustomerDto;
import com.example.customerservice.repository.CustomerRepo;
import com.example.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(ConfigsParams.class)
@EnableFeignClients

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerService customerService, CustomerRepo customerRepo) {
        return args -> {
            if (customerRepo.count() == 0) {
                for (int i = 0; i < 20; i++) {
                    customerService.createCustomer(new CustomerDto("customer" + i, "customer" + i + "@gmail.com"));

                }
            }
        };
    }

}
