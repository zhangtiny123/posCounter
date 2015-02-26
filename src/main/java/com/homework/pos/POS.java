package com.homework.pos;

public class POS
{
    public Receipt settle(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (String key : shoppingCart.getItems().keySet()) {
            OrderItem orderItemValue = shoppingCart.getItems().get(key);
            ReceiptItem receiptItem = getReceiptItem(orderItemValue);

            receipt.updateReceiptList(receiptItem);
            receipt.updateTotalPayments(orderItemValue.getSubtotalPayments());
            receipt.updateOriginTotalPayment(orderItemValue.getOriginSubtotalPayment());
        }
        return receipt;
    }

    private ReceiptItem getReceiptItem(OrderItem orderItem) {
        double subtotalPayments = orderItem.getSubtotalPayments();
        String barcode = orderItem.getGood().getBarcode();
        double price = orderItem.getGood().getPrice();
        int count = orderItem.getCount();

        return new ReceiptItem(barcode, price, count, subtotalPayments);
    }
}
