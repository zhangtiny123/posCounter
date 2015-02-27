package com.homework.pos.domain;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart
{
    private Map<String, OrderItem> goods = new HashMap<String, OrderItem>();

    public void add(OrderItem orderItem)
    {
        String orderItemKey = orderItem.getGoods().getBarcode();
        if (!goods.containsKey(orderItemKey)) {
            goods.put(orderItemKey, orderItem);
        } else {
            OrderItem exitedOrderItem = goods.get(orderItemKey);
            exitedOrderItem.plusAmount(orderItem.getAmount());
        }
    }

    public Map<String, OrderItem> getGoods()
    {
        return goods;
    }

}
