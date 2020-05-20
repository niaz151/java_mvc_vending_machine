package main.com.vendingmachine.service;

import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.Exceptions.*;

import java.util.List;

public interface Vending_Machine_Service {

    void initialize();

    Item buyItem(String item_name) throws NoItemInventoryException;

    Item getItem(String item_name);

    List<Item> getAllItems();
    
}
