package com.homework.pos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart
{
    private Map<String, OrderItem> items = new HashMap<String, OrderItem>();

    public void addItem(OrderItem orderItem)
    {
        if (!items.containsKey(orderItem.getGood().getBarcode())) {
            items.put(orderItem.getGood().getBarcode(), orderItem);
        } else {
            items.get(orderItem.getGood().getBarcode()).setCount(orderItem.getCount());
        }
    }

    public Map<String, OrderItem> getItems()
    {
        return items;
    }

}
