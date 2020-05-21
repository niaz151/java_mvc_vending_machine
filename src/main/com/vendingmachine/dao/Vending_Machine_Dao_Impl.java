package main.com.vendingmachine.dao;

import main.com.vendingmachine.dto.Item;
import main.com.vendingmachine.exceptions.NoItemInventoryException;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Vending_Machine_Dao_Impl implements  Vending_Machine_Dao{

    HashMap<String, Item> item_list = new HashMap<String, Item>();

    @Override
    public void initialize(){
        try {
            File myObj = new File("inventory.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("|");
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        }
    }

    @Override
    public Item buyItem(String item_name) throws NoItemInventoryException {
        Item item = item_list.get(item_name);
        if(item.getQuantity() <= 0){
            throw new NoItemInventoryException("No More " + item.getName() + " Remaining");
        }
        else{
            item.setQuantity(item.getQuantity() - 1);
            return item;
        }
    }

    @Override
    public Item getItem(String item_name){
        Item item = item_list.get(item_name);
        return item;
    }

    @Override
    public List<Item> getAllItems(){
        return new ArrayList<>(item_list.values());
    }

}
