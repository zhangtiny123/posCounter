package com.homework.pos;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class POSTest
{
    private POS pos;

    @Before
    public void setUp()
    {
        pos = new POS();
    }

    @Test
    public void should_return_total_payment_when_given_cart_with_only_one_good()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item(new Good("ITEM000001", 300), 1));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(300.0));
    }

    @Test
    public void should_return_total_payment_when_given_cart_with_one_good_more_than_one_count()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item(new Good("ITEM000002", 200), 5));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(1000.0));
    }
}
