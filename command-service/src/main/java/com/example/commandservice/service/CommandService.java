package com.example.commandservice.service;

import com.example.commandservice.model.dto.CommandDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommandService {

   Optional<CommandDto> getCommandById(Long id);
    CommandDto createCommand(CommandDto command);
    CommandDto udpateCommand(Long id,CommandDto command);
    boolean deleteCommand(Long id);
    public Long countCommands();
    public List<CommandDto> getCommandsByCustomerId(Long id);

    boolean commandExists(Long id);

    List<CommandDto> getAllCommands();

}
