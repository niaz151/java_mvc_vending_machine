package main.com.vendingmachine.controller;

import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.exceptions.InsufficientFundsException;
import main.com.vendingmachine.view.*;
import main.com.vendingmachine.service.*;
import main.com.vendingmachine.exceptions.NoItemInventoryException;

import java.math.BigDecimal;
import java.util.List;


public class Vending_Machine_Controller {

    private Vending_Machine_Service service;
    private Vending_Machine_View view;
    private Vending_Machine_IO io = new Vending_Machine_IO_Impl();
    private BigDecimal funds;

    public Vending_Machine_Controller(Vending_Machine_Service service, Vending_Machine_View view){
        this.service = service;
        this.view = view;
        this.funds = new BigDecimal("0.0");
    }

    public void run() throws NoItemInventoryException, InsufficientFundsException {

        boolean keepGoing = true;
        int menuSelection;

        initializeMachine();

        while(keepGoing){

            menuSelection = getMenuSelection();

            switch (menuSelection){
                case 1:
                    buyItem();
                    break;
                case 2:
                    checkItemPrice();
                    break;
                case 3:
                    checkItemQuantity();
                    break;
                case 4:
                    showAllItems();
                    break;
                case 5:
                    insertMoney();
                    break;
                case 6:
                    exitMessage();
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
    }

    public void initializeMachine(){
        service.initialize();
    }

    public int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    public void buyItem() throws NoItemInventoryException, InsufficientFundsException {
        view.seperator();
        String item_name = view.getItemName();
        Item item = service.buyItem(item_name, this.funds);
        view.buyItem(item);
        view.seperator();
    }

    public void checkItemPrice(){
        view.seperator();
        String item_name = view.getItemName();
        Item item = service.getItem(item_name);
        view.getItemPrice(item);
        view.seperator();
    }

    public void checkItemQuantity(){
        view.seperator();
        String item_name = view.getItemName();
        Item item = service.getItem(item_name);
        view.getItemQuantity(item);
        view.seperator();
    }

    public void showAllItems(){
        view.seperator();
        List<Item> item_list = service.getAllItems();
        view.showAllItems(item_list);
        view.seperator();
    }

    public void insertMoney(){
        view.seperator();
        this.funds = view.insertMoney();
    }

    public void exitMessage(){
        view.exitMsg();
    }

    public void unknownCommand(){
        view.unknownMsg();
    }

}
