package com.example.commandservice.Repository;

import com.example.commandservice.model.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepo extends JpaRepository<Command, Long> {

   List<Command> findByCustomerId(Long customerId);
}
