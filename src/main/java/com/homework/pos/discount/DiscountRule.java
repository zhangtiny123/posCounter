package com.homework.pos.discount;

import com.homework.pos.domain.DiscountTempData;

public interface DiscountRule
{
    public DiscountTempData applyDiscount(DiscountTempData discountTempData);
}
