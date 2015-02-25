package com.homework.pos;

public class ReceiptItem
{
    private String barcode;
    private double price;
    private int count;
    private double subtotal;

    public ReceiptItem(String barcode, double price, int count, double subtotal) {
        this.barcode = barcode;
        this.price = price;
        this.count = count;
        this.subtotal = subtotal;
    }

    public String getBarcode()
    {
        return barcode;
    }

    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }

    public double getSubtotal()
    {
        return subtotal;
    }
}
