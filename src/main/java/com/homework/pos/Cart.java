package com.homework.pos;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Cart
{
    private List<Item> items;

    public Cart() {this.items = newArrayList();}

    public void add(Item item)
    {
        this.items.add(item);
    }

    public List<Item> getItems()
    {
        return items;
    }
}
