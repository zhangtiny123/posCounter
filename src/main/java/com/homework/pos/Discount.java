package com.homework.pos;

public class Discount implements DiscountRule
{
    private double rate;
    public Discount(double rate)
    {
        this.rate = rate;
    }

    @Override
    public double calculateSubtotalPayments(double price, int count)
    {
        return price * count * rate;
    }
}
