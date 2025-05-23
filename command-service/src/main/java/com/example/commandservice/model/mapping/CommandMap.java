package com.example.commandservice.model.mapping;

import com.example.commandservice.model.dto.CommandDto;
import com.example.commandservice.model.dto.ProductItemDto;
import com.example.commandservice.model.entity.Command;
import com.example.commandservice.model.entity.ProductItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandMap {
    private final ProductItemMap productItemMap;

    public CommandDto toCommandDto(Command command) {
        // Convertir la liste des ProductItem en ProductItemDto
        List<ProductItemDto> productItemDtos = null;

            productItemDtos = command.getProductItem().stream()
                    .map(productItemMap::toProductItemDto) // Utiliser la méthode toProductItemDto pour la conversion
                    .collect(Collectors.toList());



        // Construire et retourner le CommandDto
        return CommandDto.builder()
                .id(command.getId())
                .command(command.getCommand())
                .description(command.getDescription())
                .createdAt(command.getCreatedAt())
                .customer_id(command.getCustomerId())
                .customer(command.getCustomerDto())
                .total_price(command.getTotal_price())
                .productItem(productItemDtos) // Ajouter la liste des ProductItemDto
                .build();
    }

    public Command toCommand(CommandDto commandDto) {
        // Convertir la liste des ProductItemDto en ProductItem
        List<ProductItem> productItems = null;

            productItems = commandDto.getProductItem().stream()
                    .map(productItemMap::toProductItem) // Utiliser la méthode toProductItem pour la conversion
                    .collect(Collectors.toList());


        // Construire et retourner la Command
        return Command.builder()
                .id(commandDto.getId())
                .command(commandDto.getCommand())
                .description(commandDto.getDescription())
                .createdAt(commandDto.getCreatedAt())
                .customerDto(commandDto.getCustomer())
                .customerId(commandDto.getCustomer_id())
                .total_price(commandDto.getTotal_price())
                .productItem(productItems) // Ajouter la liste des ProductItem
                .build();
    }


}
