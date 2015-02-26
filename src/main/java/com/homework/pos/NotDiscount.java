package com.homework.pos;

public class NotDiscount implements DiscountRule
{
    public double calculateSubtotalPayments(double price, int count) {
        return price * count;
    }
}
