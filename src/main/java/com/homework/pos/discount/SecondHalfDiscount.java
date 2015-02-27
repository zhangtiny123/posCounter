package com.homework.pos.discount;

import com.homework.pos.domain.DiscountTempData;

public class SecondHalfDiscount implements DiscountRule
{
    @Override
    public DiscountTempData applyDiscount(DiscountTempData discountTempData)
    {
        double totalPayment = discountTempData.getPrice() * discountTempData.getCount() - (discountTempData.getPrice() / 2) * (discountTempData.getCount() / 2);
        return new DiscountTempData(discountTempData.getPrice(), discountTempData.getCount(), totalPayment);
    }
}
