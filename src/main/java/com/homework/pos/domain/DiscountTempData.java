package com.homework.pos.domain;

public class DiscountTempData
{
    private double price;
    private int count;
    private double totalPayments;

    public DiscountTempData(double price, int count, double totalPayments)
    {

        this.price = price;
        this.count = count;
        this.totalPayments = totalPayments;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setTotalPayments(double totalPayments)
    {
        this.totalPayments = totalPayments;
    }

    public double getPrice()
    {
        return price;
    }

    public int getCount()
    {
        return count;
    }

    public double getTotalPayments()
    {
        return totalPayments;
    }
}
