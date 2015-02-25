package com.homework.pos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class POSTest
{

    @Test
    public void should_return_detail_list_when_given_cart_list()
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


}
