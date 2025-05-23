package com.example.commandservice.dao;

import com.example.commandservice.Repository.CommandRepo;
import com.example.commandservice.model.entity.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommandDao {
    private final CommandRepo commandRepo;

    public long countCommands() {
        return commandRepo.count();
    }


    public Command createCommand(Command command) {
        return commandRepo.save(command);
    }

    public Optional<Command> getCommandById(Long id) {
        return commandRepo.findById(id);
    }


    public List<Command> getAllCommands() {
        return commandRepo.findAll();
    }


    public boolean commandExists(Long id) {
        return commandRepo.existsById(id);
    }

    public List<Command> getCommandsByCustomerId(Long customerId) {
        return commandRepo.findByCustomerId(customerId);
    }

    public void deleteCommand(Long id) {
        commandRepo.deleteById(id);
    }

    public Command updateCommand(Command command) {
        return commandRepo.save(command);
    }


}
