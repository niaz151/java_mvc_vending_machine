package main.com.vendingmachine.service;

import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.exceptions.InsufficientFundsException;
import java.util.List;
import java.math.BigDecimal;

public class Vending_Machine_Service_Impl implements Vending_Machine_Service {

    Vending_Machine_Dao dao;

    public Vending_Machine_Service_Impl(Vending_Machine_Dao dao){
        this.dao = dao;
    }

    public void initialize(){
        dao.initialize();
    }

    public Item buyItem(String item_name, BigDecimal funds) throws InsufficientFundsException {
        Item item = dao.getItem(item_name);
        if(item.getPrice().doubleValue() > funds.doubleValue()){
            throw new InsufficientFundsException("You do not have enough funds.");
        }
        return dao.getItem(item_name);
    }

    public Item getItem(String item_name){
        return dao.getItem(item_name);
    }

    public List<Item> getAllItems(){
        return dao.getAllItems();
    }

}
