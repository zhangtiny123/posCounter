package com.homework.pos;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;

public class ShoppingCart
{
    private Map<String, Item> items = new HashMap<String, Item>();

    public void addItem(Item item)
    {
        if (!items.containsKey(item.getGood().getBarcode())) {
            items.put(item.getGood().getBarcode(), item);
        } else {
            items.get(item.getGood().getBarcode()).setCount(item.getCount());
        }
    }

    public Map<String, Item> getItems()
    {
        return items;
    }

}
