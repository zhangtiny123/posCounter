package com.homework.pos;

public class Good
{
    private String barcode;
    private double price;

    public Good(String barcode, int price)
    {
        this.barcode = barcode;
        this.price = price;

    }

    public double getPrice()
    {
        return price;
    }
}
