package main.com.vendingmachine.controller;

import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.view.*;
import main.com.vendingmachine.Exceptions.NoItemInventoryException;
import java.util.List;


public class Vending_Machine_Controller {

    private Vending_Machine_Dao dao;
    private Vending_Machine_View view;
    private Vending_Machine_IO io = new Vending_Machine_IO_Impl();

    public Vending_Machine_Controller(Vending_Machine_Dao dao, Vending_Machine_View view){
        this.dao = dao;
        this.view = view;
    }

    public void run() throws NoItemInventoryException {

        boolean keepGoing = true;
        int menuSelection = 0;

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
                    //insertMoney();
                    break;
                case 6:
                    //exitMessage();
                    keepGoing = false;
                    break;
                default:
                    //unknownCommand();
            }
        }
    }

    public void initializeMachine(){
        dao.initialize();
    }

    public int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    public void buyItem() throws NoItemInventoryException {
        view.seperator();
        String item_name = view.getItemName();
        Item item = dao.buyItem(item_name);
        view.buyItem(item);
        view.seperator();
    }

    public void checkItemPrice(){
        view.seperator();
        String item_name = view.getItemName();
        Item item = dao.getItem(item_name);
        view.getItemPrice(item);
        view.seperator();
    }

    public void checkItemQuantity(){
        view.seperator();
        String item_name = view.getItemName();
        Item item = dao.getItem(item_name);
        view.getItemQuantity(item);
        view.seperator();
    }

    public void showAllItems(){
        view.seperator();
        List<Item> item_list = dao.getAllItems();
        view.showAllItems(item_list);
        view.seperator();
    }

    public void exitMessage(){
        view.exitMsg();
    }

    public void unknownCommand(){
        view.unknownMsg();
    }

}
