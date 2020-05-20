package main.com.vendingmachine.view;

import java.util.List;
import main.com.vendingmachine.dto.Item;
import main.com.vendingmachine.Exceptions.NoItemInventoryException;

public class Vending_Machine_View {

    private Vending_Machine_IO io;

    public Vending_Machine_View(Vending_Machine_IO io){
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. Buy Item");
        io.print("2. Check Item Price");
        io.print("3. Check Item Quantity");
        io.print("4. Show All Items");
        io.print("5. Insert Money");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.");
    }

    public void showAllItems(List<Item> items){
        for(Item item: items){
            if(item.getQuantity() > 0){
                io.print(
                    item.getName() + " || " +
                    item.getPrice() + " || " +
                    item.getQuantity()
                );
            }
        }
    }

    public String getItemName(){
        return io.readString("Enter Item Name.");
    }

    public void buyItem(Item item){
        io.print("You purchased 1 " + item.getName());
    }

    public void getItemPrice(Item item){
        io.print(" = = = = = SHOWING ITEM PRICE = = = = =");
        io.print("" + item.getName() + " costs " + item.getPrice().toString());
    }

    public void getItemQuantity(Item item){
        io.print(" = = = = = SHOWING ITEM QUANTITY = = = = =");
        io.print("There are " + Integer.toString(item.getQuantity()) + " " + item.getName() + " remaining.");
    }

    public void insertMoney(Double money){
        io.print(" = = = = = INSERTING MONEY = = = = =");
        io.print( "You have inserted $" + money );
    }

    public void exitMsg(){
        io.print("Exited Program");
    }

    public void unknownMsg(){
        io.print("Command Not Recognized");
    }

    public void seperator(){ io.print(" = = = = = = = = = = "); }


}
