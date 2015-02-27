package com.homework.pos;

import com.homework.pos.domain.OrderItem;
import com.homework.pos.domain.Receipt;
import com.homework.pos.domain.ReceiptItem;
import com.homework.pos.domain.ShoppingCart;

public class POS
{
    public Receipt checkout(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (String key : shoppingCart.getGoods().keySet()) {
            OrderItem orderItemValue = shoppingCart.getGoods().get(key);
            ReceiptItem receiptItem = getReceiptItem(orderItemValue);

            receipt.updateReceiptList(receiptItem);
            receipt.updateTotalPayments(orderItemValue.getSubtotalPayments());
            receipt.updateOriginTotalPayment(orderItemValue.getOriginSubtotalPayment());
            receipt.updateTotalDifference();
        }
        return receipt;
    }

    private ReceiptItem getReceiptItem(OrderItem orderItem)
    {
        double subtotalPayments = orderItem.getSubtotalPayments();
        String barcode = orderItem.getGood().getBarcode();
        double price = orderItem.getGood().getPrice();
        int count = orderItem.getAmount();

        return new ReceiptItem(barcode, price, count, subtotalPayments);
    }
}
