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

    public double getTotalValue() {
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
        ArrayList<Item> freeItems = new ArrayList<>();
        for (Item item : shoppingBasket) {
            if (item.isBuy1Get1Free()) {
                Item freeItem = new Item(item.getName(), 0.0, item.isBuy1Get1Free());
                freeItems.add(freeItem);
            }
            }
        for (Item itemToAdd : freeItems) {
            addItem(itemToAdd);
        }
    }

    public double apply10PcDiscount() {
        if (getTotalValue() > 20.0) {
            double newTotalValue = getTotalValue() * .9;
            return newTotalValue;
        }
        double newTotalValue = getTotalValue();
        return newTotalValue;
    }

    public double apply2PcDiscount() {
        if (customerHasLoyaltyCard) {
            double loyaltyTotalValue = getTotalValue() * .98;
            return loyaltyTotalValue;
            }
        double loyaltyTotalValue = getTotalValue();
        return loyaltyTotalValue;
        }
    }

