package com.example.customerservice.proxy;

import com.example.customerservice.model.dto.Command;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "command-service")
public interface CommandProxy {

    @GetMapping("/getCommandsByCustomerId")
    public List<Command> getCommandsByCustomerId(@RequestParam Long customerId);

    @PostMapping("/createCommand")
    public Command createCommand(@RequestBody Command command);




}
