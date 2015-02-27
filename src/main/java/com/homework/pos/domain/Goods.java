package com.homework.pos.domain;

public class Goods
{
    private String barcode;
    private double price;

    public Goods(String barcode, int price)
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
