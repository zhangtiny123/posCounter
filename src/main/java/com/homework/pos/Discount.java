package com.homework.pos;

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
        if (discountTempData.getTotalPayments() == 0) {
            double totalPayment = discountTempData.getPrice() * discountTempData.getCount() * rate;
            return new DiscountTempData(discountTempData.getPrice() * rate, discountTempData.getCount(), totalPayment);
        }
        return new DiscountTempData(discountTempData.getPrice() * rate, discountTempData.getCount(), discountTempData.getTotalPayments() * rate);
    }
}
