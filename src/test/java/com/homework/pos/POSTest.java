package com.homework.pos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class POSTest
{
    @Test
    public void should_return_total_payment_when_given_cart_with_only_one_good(){
        POS pos = new POS();
        Cart cart = new Cart();
        cart.addItem(new Item(new Good("ITEM000001", 300), 1));

        double totalPayment = pos.settle(cart);

        assertThat(totalPayment, is(300.0));
    }
}
