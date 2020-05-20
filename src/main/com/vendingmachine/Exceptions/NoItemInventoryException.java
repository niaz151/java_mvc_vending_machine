package main.com.vendingmachine.Exceptions;

public class NoItemInventoryException extends Exception{
    public NoItemInventoryException(String msg){
        super(msg);
    }
}
