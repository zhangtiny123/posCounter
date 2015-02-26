package com.homework.pos;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Receipt
{
    private List<ReceiptItem> receiptItems;
    private double totalPayments;

    public Receipt()
    {
        receiptItems = newArrayList();
        totalPayments = 0;
    }

    public void setTotalPayments(double totalPayments)
    {
        totalPayments = totalPayments;
    }

    public double getTotalPayments()
    {
        return totalPayments;
    }

    public void updateTotalPayments(double subtotalPayments)
    {
        totalPayments += subtotalPayments;
    }

    public double getSubtotalByBarcode(String barcode)
    {
        for (ReceiptItem receiptItem : receiptItems) {
            if (receiptItem.getBarcode().equals(barcode)) {
                return receiptItem.getSubtotalPayments();
            }
        }
        return 0;
    }

    public void updateReceiptList(ReceiptItem receiptItem)
    {
        receiptItems.add(receiptItem);
    }
}
