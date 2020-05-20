package main.com.vendingmachine.dao;

import main.com.vendingmachine.dto.Item;
import main.com.vendingmachine.exceptions.NoItemInventoryException;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;


public class Vending_Machine_Dao_Impl implements  Vending_Machine_Dao{

    HashMap<String, Item> item_list = new HashMap<String, Item>();

    @Override
    public void initialize(){
        Item item_one = new Item("Cheetos", 10, new BigDecimal("1.00"));
        Item item_two = new Item("Doritos", 8, new BigDecimal("1.25"));
        Item item_three = new Item("Snickers", 1, new BigDecimal("1.50"));
        Item item_four = new Item("Butterfinger", 5, new BigDecimal("0.75"));
        item_list.put(item_one.getName(), item_one);
        item_list.put(item_two.getName(), item_two);
        item_list.put(item_three.getName(), item_three);
        item_list.put(item_four.getName(), item_four);
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
