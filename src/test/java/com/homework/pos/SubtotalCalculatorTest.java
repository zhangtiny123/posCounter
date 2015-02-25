package com.homework.pos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SubtotalCalculatorTest
{
    private SubtotalCalculator subtotalCalculator = new SubtotalCalculator();

    @Test
    public void should_return_250_when_given_product_price_50_and_count_5()
    {
        Item item = new Item(new Good("ITEM000001", 50), 5);

        double subtotal = subtotalCalculator.calculate(item);

        assertThat(subtotal, is(250.0));
    }

}
