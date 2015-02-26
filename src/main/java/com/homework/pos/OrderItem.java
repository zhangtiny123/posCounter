package com.homework.pos;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class OrderItem
{
    private Good good;
    private int count;
    private List<DiscountRule> discountRules = newArrayList();

    public OrderItem(Good good, int count)
    {
        this.good = good;
        this.count = count;
    }

    public Good getGood()
    {
        return this.good;
    }

    public int getCount()
    {
        return count;
    }

    public double getSubtotalPayments()
    {
        if (discountRules.size() == 0) {
            return good.getPrice() * count;
        }
        double totalPayments = 0;
        DiscountTempData discountTempData = new DiscountTempData(good.getPrice(), count, totalPayments);
        for (DiscountRule discountRule : discountRules) {
            DiscountTempData tempData = discountRule.applyDiscount(discountTempData);
            discountTempData.setPrice(tempData.getPrice());
            discountTempData.setTotalPayments(tempData.getTotalPayments());
        }
        return discountTempData.getTotalPayments();
    }

    public void setCount(int count)
    {
        this.count += count;
    }

    public void addDiscountRule(DiscountRule discountRule)
    {
        discountRules.add(discountRule);
    }

    public double getOriginSubtotalPayment()
    {
        return good.getPrice() * count;
    }
}
