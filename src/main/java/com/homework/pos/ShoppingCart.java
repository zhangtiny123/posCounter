package com.homework.pos;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ShoppingCart
{
    private List<Item> items = newArrayList();

    public void addItem(Item item)
    {
        items.add(item);
    }

    public List<Item> getItems()
    {
        return items;
    }
}
