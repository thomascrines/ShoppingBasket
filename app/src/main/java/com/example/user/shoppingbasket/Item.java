package com.example.user.shoppingbasket;

/**
 * Created by user on 22/11/2016.
 */

public class Item {
    private String name;
    private double price;
    private boolean buy1Get1Free;

    public Item(String name, double price, boolean buy1Get1Free) {
        this.name = name;
        this.price = price;
        this.buy1Get1Free = buy1Get1Free;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBuy1Get1Free() {
        return buy1Get1Free;
    }

    public void setBuy1Get1FreeStatus(boolean newStatus) {
        this.buy1Get1Free = newStatus;
    }
}

