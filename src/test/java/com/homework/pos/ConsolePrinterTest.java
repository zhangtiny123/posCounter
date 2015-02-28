package com.homework.pos;

import com.homework.pos.domain.Goods;
import com.homework.pos.domain.OrderItem;
import com.homework.pos.domain.Receipt;
import com.homework.pos.domain.ShoppingCart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class ConsolePrinterTest
{
    private static final String ITEM1 = "ITEM000001";
    private static final String ITEM2 = "ITEM000002";
    private PrintStream outContent;

    @Before
    public void setUpStreams()
    {
        outContent = mock(PrintStream.class);
        System.setOut(outContent);
    }

    @After
    public void cleanUpStreams()
    {
        System.setOut(null);
    }

    @Test
    public void should_print_receipt_to_console()
    {

        POS pos = new POS();
        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.add(getItem1(3));
        InOrder inOrder = inOrder(outContent);

        Receipt receipt = pos.checkout(shoppingCart);
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.output(receipt);

        inOrder.verify(outContent).println("购物明细\t\t\t数量\t\t单价\t\t\t小计");
        inOrder.verify(outContent).println("ITEM000001\t\t3\t\t300.0\t\t900.0");
        inOrder.verify(outContent).println("总计金额\t\t\t优惠前\t优惠后\t\t优惠差价");
        inOrder.verify(outContent).println("900.0\t\t\t900.0\t900.0\t\t0.0");

    }

    private ShoppingCart getShoppingCart() {return new ShoppingCart();}

    private OrderItem getItem1(int count) {return new OrderItem(new Goods(ITEM1, 300), count);}

    private OrderItem getItem2(int count) {return new OrderItem(new Goods(ITEM2, 200), count);}
}
