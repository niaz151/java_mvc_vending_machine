package main.com.vendingmachine.service;

import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.exceptions.InsufficientFundsException;
import java.util.List;
import java.math.BigDecimal;

public class Vending_Machine_Service_Impl implements Vending_Machine_Service {

    Vending_Machine_Dao dao;
    BigDecimal funds = new BigDecimal("0.00");

    public Vending_Machine_Service_Impl(Vending_Machine_Dao dao){
        this.dao = dao;
    }

    @Override
    public void initialize(){
        dao.initialize();
    }

    @Override
    public Item buyItem(String item_name) throws InsufficientFundsException {
        Item item = dao.getItem(item_name);
        if(item.getPrice().doubleValue() > funds.doubleValue()){
            throw new InsufficientFundsException("You only have $" +  funds.toString() );
        }
        funds = funds.subtract(item.getPrice());
        return dao.getItem(item_name);
    }

    @Override
    public Item getItem(String item_name){
        return dao.getItem(item_name);
    }

    @Override
    public List<Item> getAllItems(){
        return dao.getAllItems();
    }

    @Override
    public void addFunds(BigDecimal money){
        this.funds = this.funds.add(money);
    }

    @Override
    public BigDecimal getFunds() {
        return this.funds;
    }
}
