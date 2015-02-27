package com.homework.pos;

import com.homework.pos.business.rules.Discount;
import com.homework.pos.business.rules.DiscountRule;
import com.homework.pos.business.rules.SecondHalfDiscount;
import com.homework.pos.domain.Goods;
import com.homework.pos.domain.OrderItem;
import com.homework.pos.domain.Receipt;
import com.homework.pos.domain.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import static com.homework.pos.ShoppingCartBuilder.getShoppingCart;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class POSTest
{
    public static final String ITEM1 = "ITEM000001";
    public static final String ITEM2 = "ITEM000002";
    private POS pos;

    @Before
    public void setUp()
    {
        pos = new POS();
    }

    @Test
    public void should_return_total_payment_when_given_cart_with_only_one_good()
    {
        ShoppingCart shoppingCart = getShoppingCart().addGood(getGood1WithAmount(1)).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(300.0));
    }

    @Test
    public void should_return_total_payment_when_given_cart_with_one_good_more_than_one_count()
    {
        ShoppingCart shoppingCart = getShoppingCart().addGood(getGood2WithAmount(5)).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(1000.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_goods_more_than_one_type()
    {
        ShoppingCart shoppingCart = getShoppingCart().addGood(getGood1WithAmount(1)).addGood(getGood2WithAmount(1)).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(500.0));
    }

    @Test
    public void should_return_receipt_when_given_cart_with_more_than_one_type_and_more_than_one_count()
    {
        ShoppingCart shoppingCart = getShoppingCart().addGood(getGood1WithAmount(5)).addGood(getGood2WithAmount(3)).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(2100.0));
    }

    @Test
    public void should_return_receipt_with_subtotals_when_given_cart_without_repeatedly_adding_goods()
    {
        ShoppingCart shoppingCart = getShoppingCart().addGood(getGood1WithAmount(5)).addGood(getGood2WithAmount(3)).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode(ITEM1), is(1500.0));
        assertThat(receipt.getSubtotalByBarcode(ITEM2), is(600.0));
    }

    @Test
    public void should_return_receipt_with_subtotals_with_repeatedly_adding_goods()
    {
        ShoppingCart shoppingCart = getShoppingCart().addGood(getGood1WithAmount(5)).addGood(getGood2WithAmount(3)).addGood(getGood2WithAmount(3)).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode(ITEM1), is(1500.0));
        assertThat(receipt.getSubtotalByBarcode(ITEM2), is(1200.0));
    }

    @Test
    public void should_return_total_payment_with_discount_promotion()
    {
        DiscountRule discountRule = new Discount(0.8);
        OrderItem orderItem = getGood1WithAmount(5);
        orderItem.addDiscountRule(discountRule);
        ShoppingCart shoppingCart = getShoppingCart().addGood(orderItem).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode(ITEM1), is(1200.0));
    }

    @Test
    public void should_return_total_payment_with_second_half_promotion()
    {
        DiscountRule secondHalfDiscount = new SecondHalfDiscount();
        OrderItem orderItem = getGood1WithAmount(5);
        orderItem.addDiscountRule(secondHalfDiscount);
        ShoppingCart shoppingCart = getShoppingCart().addGood(orderItem).build();

        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode(ITEM1), is(1200.0));
    }

    @Test
    public void should_return_total_payment_with_two_different_promotion()
    {
        DiscountRule discount = new Discount(0.8);
        DiscountRule secondHalfDiscount = new SecondHalfDiscount();

        OrderItem orderItem = getGood1WithAmount(5);
        orderItem.addDiscountRule(discount);
        orderItem.addDiscountRule(secondHalfDiscount);

        ShoppingCart shoppingCart = getShoppingCart().addGood(orderItem).build();


        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getSubtotalByBarcode(ITEM1), is(960.0));
    }

    @Test
    public void should_return_total_payment_with_more_than_one_good_type_and_two_promotion()
    {
        DiscountRule discount = new Discount(0.8);
        DiscountRule secondHalfDiscount = new SecondHalfDiscount();

        OrderItem orderItem1 = getGood1WithAmount(5);
        orderItem1.addDiscountRule(secondHalfDiscount);
        orderItem1.addDiscountRule(discount);
        OrderItem orderItem2 = getGood2WithAmount(3);
        orderItem2.addDiscountRule(secondHalfDiscount);

        ShoppingCart shoppingCart = getShoppingCart().addGood(orderItem1).addGood(orderItem2).build();


        Receipt receipt = pos.checkout(shoppingCart);

        assertThat(receipt.getTotalPayments(), is(1460.0));
        assertThat(receipt.getOriginTotalPayment(), is(2100.0));
    }

    @Test
    public void should_return_receipt_with_difference_price_between_total_payment_and_origin_total_payment()
    {
        //given
        OrderItem orderItem1 = getGood1WithAmount(3);
        DiscountRule discount = new Discount(0.8);
        orderItem1.addDiscountRule(discount);

        OrderItem orderItem2 = getGood2WithAmount(5);
        DiscountRule secondHalfDiscount = new SecondHalfDiscount();
        orderItem2.addDiscountRule(secondHalfDiscount);

        ShoppingCart shoppingCart = getShoppingCart().addGood(orderItem1).addGood(orderItem2).build();

        //when
        Receipt receipt = pos.checkout(shoppingCart);

        //then
        assertThat(receipt.getTotalDifferencePrice(), is(380.0));
    }

    private OrderItem getGood1WithAmount(int amount) {return new OrderItem(new Goods(ITEM1, 300), amount);}

    private OrderItem getGood2WithAmount(int amount) {return new OrderItem(new Goods(ITEM2, 200), amount);}
}
