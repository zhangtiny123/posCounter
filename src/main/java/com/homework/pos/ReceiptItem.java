package com.homework.pos;

public class ReceiptItem
{
    private String barcode;
    private double price;
    private int count;
    private double subtotalPayments;

    public ReceiptItem(String barcode, double price, int count, double subtotalPayments)
    {
        this.barcode = barcode;
        this.price = price;
        this.count = count;
        this.subtotalPayments = subtotalPayments;
    }

    public double getPrice()
    {
        return price;
    }

    public int getCount()
    {
        return count;
    }

    public String getBarcode()
    {
        return barcode;
    }

    public double getSubtotalPayments()
    {
        return subtotalPayments;
    }
}
