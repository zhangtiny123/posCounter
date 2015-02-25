package com.homework.pos;

public class POS
{
    public Receipt settle(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        Item item = shoppingCart.getItems().get(0);
        receipt.setTotalPayments(item.getSubtotal());
        return receipt;
    }
}
