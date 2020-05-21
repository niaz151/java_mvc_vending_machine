package main.com.vendingmachine;

import main.com.vendingmachine.exceptions.InsufficientFundsException;
import main.com.vendingmachine.exceptions.NoItemInventoryException;
import main.com.vendingmachine.service.Vending_Machine_Service;
import main.com.vendingmachine.service.Vending_Machine_Service_Impl;
import main.com.vendingmachine.view.*;
import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.controller.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws NoItemInventoryException, InsufficientFundsException, IOException {
        Vending_Machine_IO io = new Vending_Machine_IO_Impl();
        Vending_Machine_Dao dao = new Vending_Machine_Dao_Impl();
        Vending_Machine_Service service = new Vending_Machine_Service_Impl(dao);
        Vending_Machine_View view = new Vending_Machine_View(io);
        Vending_Machine_Controller controller = new Vending_Machine_Controller(service, view);

        controller.run();
    }

}
