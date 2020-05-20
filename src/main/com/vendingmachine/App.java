package main.com.vendingmachine;

import main.com.vendingmachine.Exceptions.NoItemInventoryException;
import main.com.vendingmachine.view.*;
import main.com.vendingmachine.dto.*;
import main.com.vendingmachine.dao.*;
import main.com.vendingmachine.controller.*;

public class App {

    public static void main(String[] args) throws NoItemInventoryException {
        Vending_Machine_IO io = new Vending_Machine_IO_Impl();
        Vending_Machine_Dao dao = new Vending_Machine_Dao_Impl();
        Vending_Machine_View view = new Vending_Machine_View(io);
        Vending_Machine_Controller controller = new Vending_Machine_Controller(dao, view);

        controller.run();
    }

}
