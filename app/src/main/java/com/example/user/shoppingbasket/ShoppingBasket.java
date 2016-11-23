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

    public double returnTotalValueOfItems() {
        double totalValue = 0;
        for (Item item : contents) {
            totalValue += item.getPrice();
        }
        round(totalValue);
        return totalValue;
    }

    public void addItemPricesToTotalPrice() {
            totalPrice += returnTotalValueOfItems();
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

    public double round(double toRound) {
        double rounded = (double) Math.round(toRound * 100) / 100;
        return rounded;
    }

    public void applyAllDiscounts() {
        applyBuy1Get1FreeToBasket();
        apply10PcDiscount();
        apply2PcDiscount();
        }

    public String returnListOfOrder() {
        String orderList = "You ordered:\n";
        for (Item item : contents) {
            if (!item.isBuy1Get1Free()) {
                orderList += (item.getName() + "\n");
                if (item.getPrice() == 0.0) {
                    orderList += " (Plus one free " + item.getName() + ")\n";
                    }
                }
            }
        return orderList;
    }

    public String returnRetailPrice() {
        double originalPrice = 0.0;
        for (Item item : contents) {
            originalPrice += item.getPrice();
        }
        round(originalPrice);
      return "Retail price is £" + originalPrice + ".";
    }

    public double calculateBOGOFSavings() {
        double bogofValue = 0.0;
        for (Item item : contents) {
            if (item.isBuy1Get1Free()) {
                bogofValue += item.getPrice();
            }
        }
        round(bogofValue);
        return bogofValue;
    }

    public int calculateNumberOfBOGOFSavings() {
        int bogofCount = 0;
        for (Item item : contents) {
            if (item.isBuy1Get1Free()) {
                bogofCount += 1;
            }
        }
        return bogofCount;
    }

    public String returnBOGOFSavings() {
            if (calculateNumberOfBOGOFSavings() > 0) {
                return "Buy one get one free was applied to " + calculateNumberOfBOGOFSavings() + " items, giving a total saving of £" + calculateBOGOFSavings() + ".";
            }
        return null;
        }


        public String return10PcSavingsDiscount () {
            if (returnTotalValueOfItems() >= 20.0) {
                return "As you have spent over £20, a 10% discount has been applied, giving a total saving of £" + round(returnTotalValueOfItems() * .1) + ".";
            }
            return null;
        }

        public String return2PcSavingsDiscount () {
            if (customerHasLoyaltyCard) {
                return "As you have a loyalty card a 2% discount has been applied, giving a saving of £" + round(returnTotalValueOfItems() * .02) + ".";
            }
            return null;
        }

        public String returnTotalSavings () {
            double totalSavings = returnTotalValueOfItems() - totalPrice + calculateBOGOFSavings();
            return "In total, you have saved £" + round(totalSavings) + " on this transaction.";
        }

        }