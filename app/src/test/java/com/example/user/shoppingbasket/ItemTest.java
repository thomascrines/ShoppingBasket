package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/11/2016.
 */

public class ItemTest {

    Item item;

    @Before
    public void before() {
        item = new Item("Cheese", 3.25, true);
    }

    @Test
    public void testItemHasName() {
        assertEquals("Cheese", item.getName());
    }

    @Test
    public void testItemHasPrice() {
        assertEquals(3.25, item.getPrice());
    }

    @Test
    public void testItemHasBuy1Get1FreeStatus() {
        assertEquals(true, item.isBuy1Get1Free());
    }

    @Test
    public void testItemBuy1Get1FreeStatusCanBeSet() {
        item.setBuy1Get1FreeStatus(false);
        assertEquals(false, item.isBuy1Get1Free());
    }

}
