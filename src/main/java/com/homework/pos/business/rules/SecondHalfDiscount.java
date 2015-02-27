package com.homework.pos.business.rules;

import com.homework.pos.domain.DiscountTempData;

public class SecondHalfDiscount implements DiscountRule
{
    @Override
    public DiscountTempData applyDiscount(DiscountTempData discountTempData)
    {
        double totalPayment = discountTempData.price * discountTempData.count - (discountTempData.price / 2) * (discountTempData.count / 2);
        return new DiscountTempData(discountTempData.price, discountTempData.count, totalPayment);
    }
}
