package main.com.vendingmachine.service;

import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.exceptions.InsufficientFundsException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.math.BigDecimal;

public class Vending_Machine_Service_Impl implements Vending_Machine_Service {

    Vending_Machine_Dao dao;
    BigDecimal funds = new BigDecimal("0.00");

    public Vending_Machine_Service_Impl(Vending_Machine_Dao dao){
        this.dao = dao;
    }

    @Override
    public void initialize() throws FileNotFoundException {
        dao.initialize();
    }

    @Override
    public Item buyItem(String item_name) throws InsufficientFundsException {
        Item item = dao.getItem(item_name);
        if(item.getPrice().doubleValue() > funds.doubleValue()){
            throw new InsufficientFundsException("You only have $" +  funds.toString() );
        }
        item.setQuantity(item.getQuantity() -1);
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
    public void updateText() throws IOException {
        dao.updateText();
    }

    @Override
    public void addFunds(BigDecimal money){
        this.funds = this.funds.add(money);
    }

    @Override
    public BigDecimal getFunds() {
        return this.funds;
    }

    @Override
    public String[] getChange(){

        BigDecimal penny_change = funds.multiply(new BigDecimal("100"));
        BigDecimal quarter_change = penny_change.divide(new BigDecimal("25"));
        penny_change = penny_change.remainder(new BigDecimal("25"));
        BigDecimal dime_change = penny_change.divide(new BigDecimal("10"));
        penny_change = penny_change.remainder(new BigDecimal("10"));
        BigDecimal nickel_change = penny_change.divide(new BigDecimal("5"));
        penny_change = penny_change.remainder(new BigDecimal(5));

        String quarters = Integer.toString(quarter_change.intValue());
        System.out.println(quarters);
        String dimes = Integer.toString(dime_change.intValue());
        System.out.println(dimes);
        String nickels = Integer.toString(nickel_change.intValue());
        System.out.println(nickels);
        String pennies = Integer.toString(penny_change.intValue());
        System.out.println(pennies);
        String[] output = new String[]{quarters, dimes, nickels, pennies};

        return output;
    }

}
