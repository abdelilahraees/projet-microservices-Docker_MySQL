package com.example.commandservice.service;

import com.example.commandservice.dao.ProductItemDao;
import com.example.commandservice.dao.CommandDao;
import com.example.commandservice.model.dto.ProductDto;
import com.example.commandservice.model.dto.ProductItemDto;
import com.example.commandservice.model.dto.CommandDto;
import com.example.commandservice.model.dto.CustomerDto;
import com.example.commandservice.model.entity.ProductItem;
import com.example.commandservice.model.entity.Command;
import com.example.commandservice.model.mapping.ProductItemMap;
import com.example.commandservice.model.mapping.CommandMap;
import com.example.commandservice.proxy.CustomerProxy;
import com.example.commandservice.proxy.ProductProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {
    private final CommandDao commandDao;
    private final CommandMap commandMap;
    private final CustomerProxy commandProxy;
    private final ProductItemDao productItemDao;
    private final ProductItemMap productItemMap;
    private final ProductProxy productProxy;


    @Override
    public CommandDto createCommand(CommandDto commandDto) {
        // Validation des entrées
        validateCommandDto(commandDto);

        // Gérer le client associé à la commande
        handleCustomer(commandDto);

        // Convertir CommandDto en Command et le sauvegarder
        Command command = commandMap.toCommand(commandDto);
        Command savedCommand = commandDao.createCommand(command);

        // Gérer le panier associé à la commande
        List<ProductItemDto> productItemDto = handleCart(commandDto.getProductItem(), savedCommand);
        System.out.println(productItemDto);
        // Mettre à jour le CommandDto avec la liste des ProductItemDto
        commandDto.setProductItem(productItemDto);

        // Convertir la Command sauvegardée en CommandDto et la retourner
        CommandDto savedCommandDto = commandMap.toCommandDto(savedCommand);
        savedCommandDto.setProductItem(productItemDto);

        return savedCommandDto;
    }

    private void validateCommandDto(CommandDto commandDto) {
        if (commandDto == null) {
            throw new IllegalArgumentException("CommandDto cannot be null");
        }
    }

    private List<ProductItemDto> handleCart(List<ProductItemDto> productItemsDto, Command command) {
        List<ProductItemDto> productItemsDtoResult = new ArrayList<>();

        if (productItemsDto != null && !productItemsDto.isEmpty()) {
            for (ProductItemDto cartDto : productItemsDto) {
                ProductItem productItem = productItemMap.toProductItem(cartDto);
                productItem.setCommand(command); // Associer la commande au panier
                ProductItem savedCart = productItemDao.productItem(productItem); // Sauvegarder le panier

                // Convertir le ProductItem sauvegardé en ProductItemDto
                ProductItemDto savedCartDto = productItemMap.toProductItemDto(savedCart);
                productItemsDtoResult.add(savedCartDto);
            }
        }
        System.out.println(productItemsDtoResult);
        return productItemsDtoResult;
    }

    private void handleCustomer(CommandDto commandDto) {
        if (commandDto.getCustomer() != null) {
            CustomerDto customerDto = commandProxy.createCustomer(commandDto.getCustomer());
            commandDto.setCustomer_id(customerDto.getId());
            System.out.println("Customer created: " + customerDto);
        }
    }


    @Override
    public CommandDto udpateCommand(Long id, CommandDto commandDto) {
        if (commandExists(id)) {
            Command updateCommand = commandDao.getCommandById(id).get();
            updateCommand.setCommand(commandDto.getCommand());
            updateCommand.setDescription(commandDto.getDescription());
            updateCommand.setCustomerId(commandDto.getCustomer_id());
            updateCommand.setTotal_price(commandDto.getTotal_price());
            return commandMap.toCommandDto(commandDao.updateCommand(updateCommand));

        }

        return null;
    }

    @Override
    public boolean deleteCommand(Long id) {
        if (!commandExists(id)) {
            return false;
        }

        commandDao.deleteCommand(id);
        return true;
    }

    @Override
    public Long countCommands() {
        return commandDao.countCommands();
    }

    @Override
    public List<CommandDto> getCommandsByCustomerId(Long id) {
        return commandDao.getCommandsByCustomerId(id).stream().map(
                        command -> {

                            CommandDto commandDto = commandMap.toCommandDto(command);
                            if (commandDto.getProductItem() != null) {
                                for (ProductItemDto productItemDto : commandDto.getProductItem()) {
                                    Optional<ProductDto> productDto = productProxy.getProduct(productItemDto.getProductId());
                                    System.out.println("---->" + productDto);
                                    productDto.ifPresent(productItemDto::setProduct);
                                }
                            }
                            return commandDto;
                        }
                )

                .collect(Collectors.toList());
    }

    @Override
    public boolean commandExists(Long id) {
        return commandDao.commandExists(id);

    }

    @Override
    public Optional<CommandDto> getCommandById(Long id) {

        return commandDao.getCommandById(id)
                .map(commandMap::toCommandDto)
                .map(commandDto -> {
                    Optional<CustomerDto> customerDto = commandProxy.getCustomer(commandDto.getCustomer_id());
                    customerDto.ifPresent(commandDto::setCustomer);
                    if (commandDto.getProductItem() != null) {
                        for (ProductItemDto productItemDto : commandDto.getProductItem()) {
                            Optional<ProductDto> productDto = productProxy.getProduct(productItemDto.getProductId());
                            System.out.println("---->" + productDto);
                            productDto.ifPresent(productItemDto::setProduct);
                        }
                    }
                    return commandDto;
                });
    }


    @Override
    public List<CommandDto> getAllCommands() {
        return commandDao.getAllCommands().stream().map(c -> {
                            CommandDto commandDto = commandMap.toCommandDto(c);
                            if (commandDto.getProductItem() != null) {
                                for (ProductItemDto productItemDto : commandDto.getProductItem()) {
                                    Optional<ProductDto> productDto = productProxy.getProduct(productItemDto.getProductId());
                                    System.out.println("---->" + productDto);
                                    productDto.ifPresent(productItemDto::setProduct);
                                }
                            }
                            return commandDto;
                        }


                ).peek(commandDto -> {
                    Optional<CustomerDto> customerDto = commandProxy.getCustomer(commandDto.getCustomer_id());
                    customerDto.ifPresent(commandDto::setCustomer);
                })

                .collect(Collectors.toList());
    }
}
