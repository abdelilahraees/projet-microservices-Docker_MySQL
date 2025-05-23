package com.example.commandservice.web;


import com.example.commandservice.model.dto.CommandDto;
import com.example.commandservice.model.dto.ProductDto;
import com.example.commandservice.proxy.ProductProxy;
import com.example.commandservice.service.CommandService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService; //CommandService

    @GetMapping("/getCommandsByCustomerId")
    public List<CommandDto> getCommandByCustomerId(@RequestParam Long customerId) {
        return commandService.getCommandsByCustomerId(customerId);
    }

    @GetMapping("/getAllCommands")
    public List<CommandDto> getAllCommands() {
        return commandService.getAllCommands();
    }

    @GetMapping("/getCommandById")
    public Optional<CommandDto> getCommandById(@RequestParam Long id) {
        return commandService.getCommandById(id);
    }

    @DeleteMapping("/deleteCommand")
    public boolean deleteCommand(@RequestParam Long id) {
        return commandService.deleteCommand(id);
    }

    @PostMapping("/createCommand")
    public CommandDto createCommand(@RequestBody CommandDto commandDto) {
        System.out.println(commandDto);
        return commandService.createCommand(commandDto);
    }

    @PutMapping("/updateCommand")
    public CommandDto updateCommand(@RequestParam long id,@RequestBody CommandDto commandDto) {
        return commandService.udpateCommand(id, commandDto);
    }

}
