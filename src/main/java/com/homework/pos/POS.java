package com.homework.pos;

import com.homework.pos.domain.OrderItem;
import com.homework.pos.domain.Receipt;
import com.homework.pos.domain.ShoppingCart;

public class POS
{
    public Receipt checkout(ShoppingCart shoppingCart)
    {
        Receipt receipt = new Receipt();
        for (String key : shoppingCart.getGoods().keySet()) {
            OrderItem orderItemValue = shoppingCart.getGoods().get(key);

            receipt.updateElements(orderItemValue);
        }
        return receipt;
    }

}
