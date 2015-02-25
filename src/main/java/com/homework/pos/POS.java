package com.homework.pos;

public class POS
{
    public Receipt settle(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (Item item : shoppingCart.getItems()) {
            receipt.updateTotalPayments(item.getSubtotalPayments());
        }
        return receipt;
    }
}
