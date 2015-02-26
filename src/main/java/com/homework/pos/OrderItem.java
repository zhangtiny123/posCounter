package com.homework.pos;

public class OrderItem
{
    private Good good;
    private int count;

    public OrderItem(Good good, int count)
    {
        this.good = good;
        this.count = count;
    }

    public Good getGood()
    {
        return this.good;
    }

    public int getCount()
    {
        return count;
    }

    public double getSubtotalPayments()
    {
        return good.getPrice() * count;
    }

    public void setCount(int count)
    {
        this.count += count;
    }
}
