package com.example.customerservice.service;

import com.example.customerservice.dao.CustomerDao;
import com.example.customerservice.model.dto.Command;
import com.example.customerservice.model.dto.CustomerDto;
import com.example.customerservice.model.entity.Customer;
import com.example.customerservice.model.mapping.CustomerMap;
import com.example.customerservice.proxy.CommandProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerDao customerDao;
    private final CustomerMap customerMap;
    private final CommandProxy commandProxy;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        if (customerDto == null) {
            throw new IllegalArgumentException("CustomerDto cannot be null");
        }


        // Convertir et sauvegarder le client
        Customer customer = customerMap.toCustomer(customerDto);
        Customer savedCustomer = customerDao.saveCustomer(customer);

        // Créer les commandes associées au client
        createCommandsForCustomer(customerDto, savedCustomer.getId());

        // Convertir le client sauvegardé en DTO et le retourner
        return customerMap.toCustomerDto(savedCustomer);
    }

    private void createCommandsForCustomer(CustomerDto customerDto, long customerId) {
        if (customerDto.getCommands() != null && !customerDto.getCommands().isEmpty()) {
            for (Command command : customerDto.getCommands()) {
                if (command != null) {
                    command.setCustomer_id(customerId);
                    System.out.println("------>" + command.getProductItem());
                    commandProxy.createCommand(command);
                }
            }
        }
    }


    @Override
    public CustomerDto updateCustomer(long id, CustomerDto customerDto) {
        Customer updatedCustomer = customerDao.getCustomerById(id)
                .map(customer -> {
                    customer.setName(customerDto.getName());
                    customer.setEmail(customerDto.getEmail());
                    customer.setCommand_id(customerDto.getCommand_id());
                    return customerDao.updateCustomer(id, customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        return customerMap.toCustomerDto(updatedCustomer);
    }

    @Override
    public boolean deleteCustomer(long id) {
        if (!customerExists(id)) {
            return false;
        }

        customerDao.deleteCustomer(id);
        return true;
    }


    @Override
    public Optional<CustomerDto> getCustomerById(long id) {
        return customerDao.getCustomerById(id)
                .map(customerMap::toCustomerDto)
                .map(customerDto -> {
                    List<Command> commands = commandProxy.getCommandsByCustomerId(id);
                    if (commands != null) { // Vérifier si la liste n'est pas null
                        customerDto.setCommands(commands);
                    } else {
                        customerDto.setCommands(Collections.emptyList()); // Liste vide si null
                    }
                    return customerDto;
                });
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerDao.getAllCustomers().stream().map(customerMap::toCustomerDto).peek(customerDto -> {
            List<Command> commands = commandProxy.getCommandsByCustomerId(customerDto.getId());
            if (commands != null) { // Vérifier si la liste n'est pas null
                customerDto.setCommands(commands);
            } else {
                customerDto.setCommands(Collections.emptyList()); // Liste vide si null
            }
        }).collect(Collectors.toList());
    }

    @Override
    public boolean customerExists(Long id) {
        return customerDao.CustomerExists(id);
    }
}
