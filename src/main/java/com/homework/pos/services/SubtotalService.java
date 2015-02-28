package com.homework.pos.services;

import com.homework.pos.business.rules.DiscountRule;
import com.homework.pos.domain.DiscountTempData;
import com.homework.pos.domain.OrderItem;
import com.homework.pos.domain.ReceiptItem;

public class SubtotalService
{
    public SubtotalService() { }

    public double getSubtotalPayments(OrderItem orderItem)
    {
        if (orderItem.getDiscountRules().size() == 0) {
            return orderItem.getGoods().getPrice() * orderItem.getAmount();
        }
        double totalPayments = 0;
        DiscountTempData discountTempData = new DiscountTempData(orderItem.getGoods().getPrice(), orderItem.getAmount(),
                totalPayments);
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

    public ReceiptItem getReceiptItem(OrderItem orderItem)
    {
        double subtotalPayments = getSubtotalPayments(orderItem);
        String barcode = orderItem.getGoods().getBarcode();
        double price = orderItem.getGoods().getPrice();
        int count = orderItem.getAmount();

        return new ReceiptItem(barcode, price, count, subtotalPayments);
    }
}