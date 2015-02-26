package com.homework.pos;

public class OrderItem
{
    private Good good;
    private int count;
    private DiscountRule discountRule = new NotDiscount();

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
        return discountRule.calculateSubtotalPayments(good.getPrice(), count);
    }

    public void setCount(int count)
    {
        this.count += count;
    }

    public void setDiscountRule(DiscountRule discountRule)
    {
        this.discountRule = discountRule;
    }
}
