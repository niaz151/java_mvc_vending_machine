package main.com.vendingmachine.view;

import java.math.BigDecimal;

public interface Vending_Machine_IO {

    void print(String msg);

    String readString(String msg);

    BigDecimal readBigDecimal(String msg);

    int readInt(String msg);

}
