package main.com.vendingmachine.dao;

import java.util.List;

import main.com.vendingmachine.Exceptions.NoItemInventoryException;
import main.com.vendingmachine.dto.Item;

public interface Vending_Machine_Dao {

    void initialize();

    Item buyItem(String item_name) throws NoItemInventoryException;

    Item getItem(String item_name);

    List<Item> getAllItems();

}
