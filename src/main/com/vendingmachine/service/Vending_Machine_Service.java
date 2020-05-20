package main.com.vendingmachine.service;

import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.exceptions.*;
import java.math.BigDecimal;
import java.util.List;

public interface Vending_Machine_Service {

    void initialize();

    Item buyItem(String item_name, BigDecimal funds) throws
            NoItemInventoryException,
            InsufficientFundsException;

    Item getItem(String item_name);

    List<Item> getAllItems();
    
}
