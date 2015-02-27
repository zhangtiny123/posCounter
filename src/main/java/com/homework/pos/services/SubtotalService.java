package com.homework.pos.services;

import com.homework.pos.business.rules.DiscountRule;
import com.homework.pos.domain.DiscountTempData;
import com.homework.pos.domain.OrderItem;

public class SubtotalService
{
    public SubtotalService() { }

    public double getSubtotalPayments(OrderItem orderItem)
    {
        if (orderItem.getDiscountRules().size() == 0) {
            return orderItem.getGoods().getPrice() * orderItem.getAmount();
        }
        double totalPayments = 0;
        DiscountTempData discountTempData = new DiscountTempData(orderItem.getGoods().getPrice(), orderItem.getAmount(), totalPayments);
        for (DiscountRule discountRule : orderItem.getDiscountRules()) {
            DiscountTempData tempData = discountRule.applyDiscount(discountTempData);
            discountTempData.price = tempData.price;
            discountTempData.totalPayments = tempData.totalPayments;
        }
        return discountTempData.totalPayments;
    }

    public double getOriginSubtotalPayment(OrderItem orderItem)
    {
        return orderItem.getGoods().getPrice() * orderItem.getAmount();
    }
}