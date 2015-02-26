package com.homework.pos;

import java.util.Map;

public class POS
{
    public Receipt settle(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (String key : shoppingCart.getItems().keySet() ) {
            OrderItem orderItemValue = shoppingCart.getItems().get(key);
            ReceiptItem receiptItem = new ReceiptItem(orderItemValue.getGood().getBarcode(), orderItemValue.getGood().getPrice(), orderItemValue.getCount(), orderItemValue.getSubtotalPayments());

            receipt.updateReceiptList(receiptItem);
            receipt.updateTotalPayments(orderItemValue.getSubtotalPayments());
        }
        return receipt;
    }
}
