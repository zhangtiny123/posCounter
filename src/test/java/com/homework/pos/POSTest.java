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
        shoppingCart.addItem(new OrderItem(new Good("ITEM000001", 300), 1));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(300.0));
    }

    @Test
    public void should_return_total_payment_when_given_cart_with_one_good_more_than_one_count()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new OrderItem(new Good("ITEM000002", 200), 5));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(1000.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_goods_more_than_one_type()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new OrderItem(new Good("ITEM000001", 300), 1));
        shoppingCart.addItem(new OrderItem(new Good("ITEM000002", 200), 1));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(500.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_more_than_one_type_and_more_than_one_count()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new OrderItem(new Good("ITEM000001", 300), 5));
        shoppingCart.addItem(new OrderItem(new Good("ITEM000002", 200), 3));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(2100.0));
    }

    @Test
    public void should_return_receipt_with_subtotals_when_given_cart_without_repeatedly_adding_goods()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new OrderItem(new Good("ITEM000001", 300), 5));
        shoppingCart.addItem(new OrderItem(new Good("ITEM000002", 200), 3));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode("ITEM000001"), is(1500.0));
        assertThat(receipt.getSubtotalByBarcode("ITEM000002"), is(600.0));
    }

    @Test
    public void should_return_receipt_with_subtotals_with_repeatedly_adding_goods(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new OrderItem(new Good("ITEM000001", 300), 5));
        shoppingCart.addItem(new OrderItem(new Good("ITEM000002", 200), 3));
        shoppingCart.addItem(new OrderItem(new Good("ITEM000002", 200), 3));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode("ITEM000001"), is(1500.0));
        assertThat(receipt.getSubtotalByBarcode("ITEM000002"), is(1200.0));
    }
}
