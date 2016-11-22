package com.example.user.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasket {

    private boolean customerHasLoyaltyCard;
    private double valueOfContents;
    private ArrayList<Item> shoppingBasket;

    public ShoppingBasket() {
        this.shoppingBasket = new ArrayList<>();
        this.customerHasLoyaltyCard = false;
        this.valueOfContents = 0.0;
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

    public void addToValueOfContents() {
        for (Item item : shoppingBasket) {
            valueOfContents += item.getPrice();
        }
    }

    public double getValueOfContents() {
        return valueOfContents;
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

    public void apply10PcDiscount() {
        if (valueOfContents >= 20.0) {
            valueOfContents = valueOfContents * .9;
        }
    }

    public void apply2PcDiscount() {
        if (customerHasLoyaltyCard) {
            valueOfContents = valueOfContents * .98;
            }
        }

    public void applyAllDiscounts() {
        applyBuy1Get1FreeToBasket();
        apply10PcDiscount();
        apply2PcDiscount();
        }
    }



