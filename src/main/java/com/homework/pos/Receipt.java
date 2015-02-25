package com.homework.pos;

import java.util.ArrayList;
import java.util.List;

public class Receipt
{
    private double total;
    public List<ReceiptItem> receiptItemList = new ArrayList<ReceiptItem>();

    public double getSubtotalBy(String barcode)
    {
        for (ReceiptItem receiptItem : receiptItemList) {
            if (receiptItem.getBarcode().equals(barcode)) {
                return receiptItem.getSubtotal();
            }
        }
        return 0;
    }

    public double getTotal()
    {
        return total;
    }

    public void totalUpdate(double tempSubtotal)
    {
        this.total += tempSubtotal;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }
}
