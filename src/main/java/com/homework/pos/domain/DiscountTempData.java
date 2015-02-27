package com.homework.pos.domain;

public class DiscountTempData
{
    public double price;
    public int count;
    public double totalPayments;

    public DiscountTempData(double price, int count, double totalPayments)
    {

        this.price = price;
        this.count = count;
        this.totalPayments = totalPayments;
    }
}
