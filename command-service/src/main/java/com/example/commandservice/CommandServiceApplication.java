package com.example.commandservice;

import com.example.commandservice.model.dto.CommandDto;
import com.example.commandservice.model.dto.ProductDto;
import com.example.commandservice.model.dto.ProductItemDto;
import com.example.commandservice.service.CommandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
@EnableFeignClients

public class CommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CommandService commandService) {
        return args -> {

            if (commandService.countCommands() == 0) {
                for (int i = 0; i < 20; i++) {
                    commandService.createCommand(new CommandDto("command" + i, "description" + i, 1, 100));

                }

            }
        };
    }

}
