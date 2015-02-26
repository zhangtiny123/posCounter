package com.homework.pos;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Receipt
{
    private List<ReceiptItem> receiptItems;
    private double totalPayments;
    private double originTotalPayments;

    public Receipt()
    {
        receiptItems = newArrayList();
        totalPayments = 0;
        originTotalPayments = 0;
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

    public double getOriginTotalPayment()
    {
        return originTotalPayments;
    }

    public void updateOriginTotalPayment(double originSubtotalPayment)
    {
        originTotalPayments += originSubtotalPayment;
    }


    public List<ReceiptItem> getReceiptItems()
    {
        return receiptItems;
    }
}
