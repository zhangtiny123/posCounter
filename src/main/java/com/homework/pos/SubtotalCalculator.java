package com.homework.pos;

public class SubtotalCalculator
{
    public double calculate(Item item)
    {
        return item.getGood().getPrice() * item.getCount();
    }
}
