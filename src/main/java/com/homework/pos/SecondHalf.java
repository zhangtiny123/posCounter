package com.homework.pos;

public class SecondHalf implements DiscountRule
{
    @Override
    public DiscountTempData applyDiscount(DiscountTempData discountTempData)
    {
        double totalPayment = discountTempData.getPrice() * discountTempData.getCount() - (discountTempData.getPrice() / 2) * (discountTempData.getCount() / 2);
        return new DiscountTempData(discountTempData.getPrice(), discountTempData.getCount(), totalPayment);
    }
}
