package com.homework.pos.domain;

import com.homework.pos.discount.DiscountRule;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class OrderItem
{
    private Good good;
    private int amount;
    private List<DiscountRule> discountRules = newArrayList();

    public OrderItem(Good good, int amount)
    {
        this.good = good;
        this.amount = amount;
    }

    public Good getGood()
    {
        return this.good;
    }

    public int getAmount()
    {
        return amount;
    }

    public double getSubtotalPayments()
    {
        if (discountRules.size() == 0) {
            return good.getPrice() * amount;
        }
        double totalPayments = 0;
        DiscountTempData discountTempData = new DiscountTempData(good.getPrice(), amount, totalPayments);
        for (DiscountRule discountRule : discountRules) {
            DiscountTempData tempData = discountRule.applyDiscount(discountTempData);
            discountTempData.setPrice(tempData.getPrice());
            discountTempData.setTotalPayments(tempData.getTotalPayments());
        }
        return discountTempData.getTotalPayments();
    }

    public void plusAmount(int amount)
    {
        this.amount += amount;
    }

    public void addDiscountRule(DiscountRule discountRule)
    {
        discountRules.add(discountRule);
    }

    public double getOriginSubtotalPayment()
    {
        return good.getPrice() * amount;
    }
}
