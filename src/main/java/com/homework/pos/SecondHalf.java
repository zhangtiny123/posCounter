package com.homework.pos;

public class SecondHalf implements DiscountRule
{
    @Override
    public double calculateSubtotalPayments(double price, int count)
    {
        return price * count - (price/2) * (count/2);
    }
}
