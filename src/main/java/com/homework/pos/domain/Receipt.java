package com.homework.pos.domain;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Receipt
{
    private List<ReceiptItem> receiptItems;
    private double totalPayments;
    private double originTotalPayments;
    private double totalDifferencePrice;

    public Receipt()
    {
        receiptItems = newArrayList();
        totalPayments = 0;
        originTotalPayments = 0;
        totalDifferencePrice = 0;
    }

    public void updateReceiptList(ReceiptItem receiptItem)
    {
        receiptItems.add(receiptItem);
    }

    public void updateTotalPayments(double subtotalPayments)
    {
        totalPayments += subtotalPayments;
    }

    public void updateOriginTotalPayment(double originSubtotalPayment)
    {
        originTotalPayments += originSubtotalPayment;
    }

    public void updateTotalDifference()
    {
        totalDifferencePrice = originTotalPayments - totalPayments;
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

    public double getTotalPayments()
    {
        return totalPayments;
    }

    public double getOriginTotalPayment()
    {
        return originTotalPayments;
    }


    public List<ReceiptItem> getReceiptItems()
    {
        return receiptItems;
    }

    public double getTotalDifferencePrice()
    {
        return totalDifferencePrice;
    }
}
