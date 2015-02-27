package com.homework.pos;

import com.homework.pos.domain.*;
import com.homework.pos.services.SubtotalService;

public class POS
{
    private final SubtotalService subtotalService = new SubtotalService();

    public Receipt checkout(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (String key : shoppingCart.getGoods().keySet()) {
            OrderItem orderItemValue = shoppingCart.getGoods().get(key);
            ReceiptItem receiptItem = getReceiptItem(orderItemValue);

            receipt.updateReceiptList(receiptItem);
            receipt.updateTotalPayments(subtotalService.getSubtotalPayments(orderItemValue));
            receipt.updateOriginTotalPayment(subtotalService.getOriginSubtotalPayment(orderItemValue));
            receipt.updateTotalDifference();
        }
        return receipt;
    }

    private ReceiptItem getReceiptItem(OrderItem orderItem)
    {
        double subtotalPayments = subtotalService.getSubtotalPayments(orderItem);
        String barcode = orderItem.getGoods().getBarcode();
        double price = orderItem.getGoods().getPrice();
        int count = orderItem.getAmount();

        return new ReceiptItem(barcode, price, count, subtotalPayments);
    }
}
