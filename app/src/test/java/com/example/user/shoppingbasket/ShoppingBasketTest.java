package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;
    ArrayList<Double> testArray;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
        item1 = new Item("Orange Juice", 1.50, true);
        item2 = new Item("Butter", 0.75, false);
        item3 = new Item("Croissant", 1.00, true);
        item4 = new Item("Kettle", 19.99, false);
        item5 = new Item("Waffle Iron", 25.99, true);
        testArray = new ArrayList<>();
        testArray.add(1.50);
        testArray.add(0.75);
        testArray.add(1.00);

    }

    @Test
    public void testCanAddItemToBasket() {
        shoppingBasket.addItem(item1);
        assertEquals(1, shoppingBasket.getShoppingBasket().size());
    }

    @Test
    public void testCanRemoveItemFromBasket() {
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        shoppingBasket.removeItem(item2);
        assertEquals(1, shoppingBasket.getShoppingBasket().size());
    }

    @Test
    public void testCanSetCustomerHasLoyaltyCard() {
        shoppingBasket.setCustomerHasLoyaltyCard();
        assertEquals(true, shoppingBasket.getCustomerHasLoyaltyCard());
    }

    @Test
    public void testBuy1Get1Free() {
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        shoppingBasket.addItem(item3);
        shoppingBasket.applyBuy1Get1FreeToBasket();
        assertEquals(3.25, shoppingBasket.getTotalValue());
        assertEquals(5, shoppingBasket.getShoppingBasket().size());
    }

    @Test
    public void testCanApply10PcDiscount() {
        shoppingBasket.addItem(item5);
        assertEquals(23.4, shoppingBasket.apply10PcDiscount(), 0.1);
    }

    @Test
    public void test10PcNotForUnder20() {
        shoppingBasket.addItem(item1);
        assertEquals(1.50, shoppingBasket.apply10PcDiscount());
    }

    @Test
    public void testCanApply2PcDiscountWithLoyaltyCard() {
        shoppingBasket.addItem(item1);
        shoppingBasket.setCustomerHasLoyaltyCard();
        assertEquals(1.47, shoppingBasket.apply2PcDiscount(), 0.1);
    }

    @Test
    public void testCantApply2PcDiscountWithoutLoyaltyCard() {
        shoppingBasket.addItem(item1);
        assertEquals(1.50, shoppingBasket.apply2PcDiscount(), 0.1);
    }

}
