package com.homework.pos;

public class Good
{
    private String barcode;
    private double price;

    public Good(String barcode, double price)
    {
        this.barcode = barcode;
        this.price = price;

    }

    public double getPrice()
    {
        return price;
    }

    public String getBarcode()
    {
        return barcode;
    }
}
