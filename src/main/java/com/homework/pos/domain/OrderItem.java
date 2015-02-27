package com.homework.pos.domain;

import com.homework.pos.business.rules.DiscountRule;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class OrderItem
{
    private Goods goods;
    private int amount;
    private List<DiscountRule> discountRules = newArrayList();

    public OrderItem(Goods goods, int amount)
    {
        this.goods = goods;
        this.amount = amount;
    }

    public Goods getGoods()
    {
        return this.goods;
    }

    public int getAmount()
    {
        return amount;
    }

    public void plusAmount(int amount)
    {
        this.amount += amount;
    }

    public void addDiscountRule(DiscountRule discountRule)
    {
        discountRules.add(discountRule);
    }

    public List<DiscountRule> getDiscountRules()
    {
        return discountRules;
    }
}
