package com.homework.pos;

public class Item
{
    private Good good;
    private int count;

    public Item(Good good, int count)
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

    public double getSubtotalPayments() {
        return good.getPrice() * count;
    }
}
