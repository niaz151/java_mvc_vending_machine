package main.com.vendingmachine.exceptions;

public class NoItemInventoryException extends Exception{
    public NoItemInventoryException(String msg){
        super(msg);
    }
}
