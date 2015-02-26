package com.homework.pos;

import java.util.Iterator;
import java.util.Map;

public class POS
{
    public Receipt settle(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (Object object : shoppingCart.getItems().entrySet()) {
            Map.Entry entry = (Map.Entry) object;
            Item itemValue = (Item) entry.getValue();
            ReceiptItem receiptItem = new ReceiptItem(itemValue.getGood().getBarcode(), itemValue.getGood().getPrice(), itemValue.getCount(), itemValue.getSubtotalPayments());

            receipt.updateReceiptList(receiptItem);
            receipt.updateTotalPayments(itemValue.getSubtotalPayments());
        }
        return receipt;
    }
}
