package com.homework.pos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class POSTest
{

    @Test
    public void should_return_receipt_list_when_given_cart_with_one_product()
    {
        // given
        POS pos = new POS();
        Cart cart = new Cart();
        cart.add(new Item(new Good("ITEM000008", 495.0), 1));

        // when
        Receipt receipt = pos.settle(cart);

        // then
        assertThat(receipt.getTotal(), is(495.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_one_product_but_more_than_one_count()
    {
        // given
        POS pos = new POS();
        Cart cart = new Cart();
        cart.add(new Item(new Good("ITEM000003", 70), 12));

        // when
        Receipt receipt = pos.settle(cart);

        //then
        assertThat(receipt.getTotal(), is(840.0));
    }
}
