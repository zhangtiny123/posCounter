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
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.addItem(getItem1(1));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(300.0));
    }

    @Test
    public void should_return_total_payment_when_given_cart_with_one_good_more_than_one_count()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.addItem(getItem2(5));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(1000.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_goods_more_than_one_type()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.addItem(getItem1(1));
        shoppingCart.addItem(getItem2(1));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(500.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_more_than_one_type_and_more_than_one_count()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.addItem(getItem1(5));
        shoppingCart.addItem(getItem2(3));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(2100.0));
    }

    @Test
    public void should_return_receipt_with_subtotals_when_given_cart_without_repeatedly_adding_goods()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.addItem(getItem1(5));
        shoppingCart.addItem(getItem2(3));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode("ITEM000001"), is(1500.0));
        assertThat(receipt.getSubtotalByBarcode("ITEM000002"), is(600.0));
    }

    @Test
    public void should_return_receipt_with_subtotals_with_repeatedly_adding_goods()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.addItem(getItem1(5));
        shoppingCart.addItem(getItem2(3));
        shoppingCart.addItem(getItem2(3));

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode("ITEM000001"), is(1500.0));
        assertThat(receipt.getSubtotalByBarcode("ITEM000002"), is(1200.0));
    }

    @Test
    public void should_return_total_payment_with_discount_promotion()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        DiscountRule discountRule = new Discount(0.8);
        OrderItem orderItem = getItem1(5);
        orderItem.setDiscountRule(discountRule);
        shoppingCart.addItem(orderItem);

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(1200.0));
    }

    @Test
    public void should_return_total_payment_with_second_half_promotion()
    {
        ShoppingCart shoppingCart = getShoppingCart();
        DiscountRule discount = new Discount(0.8);
        DiscountRule secondHalf = new SecondHalf();
        OrderItem orderItem1 = getItem1(5);
        orderItem1.setDiscountRule(secondHalf);
        shoppingCart.addItem(orderItem1);

        Receipt receipt = pos.settle(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode("ITEM000001"), is(1200.0));
    }



    private ShoppingCart getShoppingCart() {return new ShoppingCart();}

    private OrderItem getItem1(int count) {return new OrderItem(new Good("ITEM000001", 300), count);}

    private OrderItem getItem2(int count) {return new OrderItem(new Good("ITEM000002", 200), count);}
}
