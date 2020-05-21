package main.com.vendingmachine.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import main.com.vendingmachine.exceptions.NoItemInventoryException;
import main.com.vendingmachine.dto.Item;

public interface Vending_Machine_Dao {

    void initialize() throws FileNotFoundException;

    Item buyItem(String item_name) throws NoItemInventoryException;

    Item getItem(String item_name);

    List<Item> getAllItems();

    void updateText() throws IOException;

}
