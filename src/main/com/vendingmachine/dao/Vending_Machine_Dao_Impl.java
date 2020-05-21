package main.com.vendingmachine.dao;

import main.com.vendingmachine.dto.Item;
import main.com.vendingmachine.exceptions.NoItemInventoryException;

import java.io.*;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Scanner;


public class Vending_Machine_Dao_Impl implements  Vending_Machine_Dao{

    HashMap<String, Item> item_list = new HashMap<String, Item>();

    @Override
    public void initialize() throws FileNotFoundException {
        File myObj = new File("src/main/./com/vendingmachine/inventory.txt");
        Scanner scanner = new Scanner(myObj);
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(":");
            String item_name = data[0];
            int item_quantity = Integer.parseInt(data[1]);
            BigDecimal item_price = new BigDecimal(data[2]);
            Item item = new Item(item_name, item_quantity, item_price);
            item_list.put(item_name, item);
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


    @Override
    public void updateText() throws IOException {
        BufferedWriter myObj = new BufferedWriter(new FileWriter("src/main/./com/vendingmachine/inventory.txt"));
        System.out.println(item_list.values().size());
        for(Item item: item_list.values()){
            String item_name = item.getName();
            String item_quantity = Integer.toString(item.getQuantity());
            String item_price = item.getPrice().toString();
            myObj.write(item_name + ":" + item_quantity + ":" + item_price);
            myObj.write("\n");
        }
        myObj.flush();
        myObj.close();
    }

}
