package com.homework.pos;

import org.junit.Test;

/**
 * Created by taozhang on 2/25/15.
 */
public class SubtotalCalculatorTest {
    private SubtotalCalculator subtotalCalculator;

    @Test
    public void should_return_250_when_given_product_price_50_and_count_5(){
        Item item = new Item(new Good("ITEM000001", 50), 5);
    }
}
