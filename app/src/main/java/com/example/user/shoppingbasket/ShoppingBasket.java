package com.example.user.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasket {

    private boolean customerHasLoyaltyCard;
    private double totalPrice;
    private ArrayList<Item> contents;

    public ShoppingBasket() {
        this.contents = new ArrayList<>();
        this.customerHasLoyaltyCard = false;
        this.totalPrice = 0.0;
    }

    public ArrayList<Item> getContents() {
        return this.contents;
    }

    public void addItem(Item item) {
        contents.add(item);
    }

    public void removeItem(Item item) {
        contents.remove(item);
    }

    public void addItemPricesToTotalPrice() {
        for (Item item : contents) {
            totalPrice += item.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean getCustomerHasLoyaltyCard() {
        return this.customerHasLoyaltyCard;
    }

    public void setCustomerHasLoyaltyCard() {
        this.customerHasLoyaltyCard = true;
    }

    public void applyBuy1Get1FreeToBasket() {
        ArrayList<Item> freeItems = new ArrayList<>();
        for (Item item : contents) {
            if (item.isBuy1Get1Free()) {
                Item freeItem = new Item(item.getName(), 0.0, false);
                freeItems.add(freeItem);
            }
            }
        for (Item itemToAdd : freeItems) {
            addItem(itemToAdd);
        }
    }

    public void apply10PcDiscount() {
        if (totalPrice >= 20.0) {
            totalPrice = totalPrice * .9;
        }
    }

    public void apply2PcDiscount() {
        if (customerHasLoyaltyCard) {
            totalPrice = totalPrice * .98;
            }
        }

    public void applyAllDiscounts() {
        applyBuy1Get1FreeToBasket();
        apply10PcDiscount();
        apply2PcDiscount();
        }

    }



