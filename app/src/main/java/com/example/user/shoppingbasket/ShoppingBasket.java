package com.example.user.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasket {

    private boolean customerHasLoyaltyCard;
    private ArrayList<Item> shoppingBasket;

    public ShoppingBasket() {
        this.shoppingBasket = new ArrayList<>();
        this.customerHasLoyaltyCard = false;
    }

    public ArrayList<Item> getShoppingBasket() {
        return this.shoppingBasket;
    }

    public void addItem(Item item) {
        shoppingBasket.add(item);
    }

    public void removeItem(Item item) {
        shoppingBasket.remove(item);
    }

    public ArrayList<Double> getEveryPrice() {
        ArrayList<Double> everyPrice = new ArrayList<>();
        for (Item item : shoppingBasket) {
            everyPrice.add(item.getPrice());
        }
        return everyPrice;
    }

    public double calculateTotalValue() {
        double total = 0;
        for (Item item : shoppingBasket) {
            total += item.getPrice();
        }
        return total;
    }

    public boolean getCustomerHasLoyaltyCard() {
        return this.customerHasLoyaltyCard;
    }

    public void setCustomerHasLoyaltyCard() {
        this.customerHasLoyaltyCard = true;
    }

    public void applyBuy1Get1FreeToBasket() {
        for (Item item : shoppingBasket) {
            if (item.isBuy1Get1Free()) {
                Item freeItem = new Item(item.getName(), item.getPrice(), item.isBuy1Get1Free());
                freeItem.setPriceToFree();
                shoppingBasket.add(freeItem);
            }
        }
    }

    public double apply10PcDiscount() {
        if (calculateTotalValue() > 20.0) {
            double newTotalValue = calculateTotalValue() * .9;
            return newTotalValue;
        }
        double newTotalValue = calculateTotalValue();
        return newTotalValue;
    }

    public double apply2PcDiscount() {
        if (customerHasLoyaltyCard) {
            double loyaltyTotalValue = calculateTotalValue() * .98;
            return loyaltyTotalValue;
            }
        double loyaltyTotalValue = calculateTotalValue();
        return loyaltyTotalValue;
        }
    }

