package com.homework.pos;

import com.homework.pos.domain.OrderItem;
import com.homework.pos.domain.ShoppingCart;

public class ShoppingCartBuilder
{
    private ShoppingCart shoppingCart = new ShoppingCart();

    public static ShoppingCartBuilder getShoppingCart() {
        return new ShoppingCartBuilder();
    }

    public ShoppingCartBuilder addGood(OrderItem orderItem)
    {
        shoppingCart.add(orderItem);
        return this;
    }

    public ShoppingCart build()
    {
        return shoppingCart;
    }

}
