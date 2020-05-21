package main.com.vendingmachine.service;

import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface Vending_Machine_Service {

    void initialize() throws FileNotFoundException;

    Item buyItem(String item_name) throws NoItemInventoryException, InsufficientFundsException;

    Item getItem(String item_name);

    List<Item> getAllItems();

    void updateText() throws IOException;

    void addFunds(BigDecimal money);

    BigDecimal getFunds();

}
