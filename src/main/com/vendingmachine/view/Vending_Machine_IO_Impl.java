package main.com.vendingmachine.view;

import java.util.Scanner;
import java.math.BigDecimal;

public class Vending_Machine_IO_Impl implements Vending_Machine_IO{

    Scanner reader;

    public Vending_Machine_IO_Impl(){
        reader = new Scanner(System.in);
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String msg) {
        System.out.println(msg);
        return reader.nextLine();
    }

    @Override
    public BigDecimal readBigDecimal(String msg) {
        System.out.println(msg);
        Double val = Double.parseDouble((reader.nextLine()));
        return new BigDecimal(val);
    }

    @Override
    public int readInt(String msg){
        System.out.println(msg);
        return Integer.parseInt(reader.nextLine());
    }
}
