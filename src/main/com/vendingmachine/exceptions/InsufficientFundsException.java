package main.com.vendingmachine.exceptions;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String msg){
        super(msg);
    }
}
