package com.homework.pos.services;

import com.homework.pos.business.rules.Discount;
import com.homework.pos.business.rules.DiscountRule;
import com.homework.pos.business.rules.SecondHalfDiscount;
import com.homework.pos.domain.Goods;
import com.homework.pos.domain.OrderItem;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubtotalServiceTest
{

    private final SubtotalService subtotalService = new SubtotalService();

    @Test
    public void should_return_subtotal_payments_when_given_order_item_without_discount()
    {
        // given
        OrderItem orderItem = new OrderItem(getGoods1(), 5);

        //when
        double subtotalPayments = subtotalService.getSubtotalPayments(orderItem);

        //then
        assertThat(subtotalPayments, is(250.0));
    }

    @Test
    public void should_return_subtotal_payments_when_given_order_item_with_discount()
    {
        // given
        OrderItem orderItem = new OrderItem(getGoods1(), 5);
        orderItem.addDiscountRule(getDiscount(0.5));

        //when
        double subtotalPayment = subtotalService.getSubtotalPayments(orderItem);

        //then
        assertThat(subtotalPayment, is(125.0));
    }

    @Test
    public void should_return_subtotal_payment_when_given_item_with_double_discount()
    {
        // given
        OrderItem orderItem = new OrderItem(getGoods1(), 10);
        orderItem.addDiscountRule(getDiscount(0.8));
        orderItem.addDiscountRule(getSecondHalfDiscount());

        //when
        double subtotalPayment = subtotalService.getSubtotalPayments(orderItem);

        //then
        assertThat(subtotalPayment, is(300.0));
    }

    @Test
    public void should_return_subtotal_payment_when_given_item_with_double_promotion_and_second_half_first()
    {
        // given
        OrderItem orderItem = new OrderItem(getGoods1(), 10);
        orderItem.addDiscountRule(getSecondHalfDiscount());
        orderItem.addDiscountRule(getDiscount(0.8));

        //when
        double subtotalPayment = subtotalService.getSubtotalPayments(orderItem);

        //then
        assertThat(subtotalPayment, is(300.0));
    }

    @Test
    public void should_return_origin_subtotal_when_given_any_item()
    {
        // given
        OrderItem orderItem1 = new OrderItem(getGoods1(), 10);
        OrderItem orderItem2 = new OrderItem(getGoods2(), 3);

        orderItem1.addDiscountRule(getDiscount(0.8));

        //when
        double originSubtotalPayment1 = subtotalService.getOriginSubtotalPayment(orderItem1);
        double originSubtotalPayment2 = subtotalService.getOriginSubtotalPayment(orderItem2);

        //then
        assertThat(originSubtotalPayment1, is(500.0));
        assertThat(originSubtotalPayment2, is(300.0));
    }

    private Goods getGoods2() {return new Goods("ITEM000002", 100);}

    private Goods getGoods1() {return new Goods("ITEM000001", 50);}

    private Discount getDiscount(double rate) {return new Discount(rate);}

    private SecondHalfDiscount getSecondHalfDiscount() {return new SecondHalfDiscount();}
}