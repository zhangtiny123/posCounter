package com.homework.pos.business.rules;

import com.homework.pos.domain.DiscountTempData;

public class Discount implements DiscountRule
{
    private double rate;

    public Discount(double rate)
    {
        this.rate = rate;
    }

    @Override
    public DiscountTempData applyDiscount(DiscountTempData discountTempData)
    {
        if (discountTempData.totalPayments == 0) {
            double totalPayment = discountTempData.price * discountTempData.count * rate;
            return new DiscountTempData(discountTempData.price * rate, discountTempData.count, totalPayment);
        }
        return new DiscountTempData(discountTempData.price * rate, discountTempData.count, discountTempData.totalPayments * rate);
    }
}
