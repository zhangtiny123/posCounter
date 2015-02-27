package com.homework.pos.business.rules;

import com.homework.pos.domain.DiscountTempData;

public interface DiscountRule
{
    public DiscountTempData applyDiscount(DiscountTempData discountTempData);
}
