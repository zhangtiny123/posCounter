package com.homework.pos;

import java.util.List;

public class POS
{
    public Receipt settle(Cart cart)
    {
        Receipt receipt = new Receipt();
        Item item = cart.getItems().get(0);
        receipt.setTotal(item.getSubtotal());
        return receipt;
    }
    //    public PosSystem(SubtotalCalculator subtotalCalculator)
//    {
//        this.subtotalCalculator = subtotalCalculator;
//    }
//
//    private SubtotalCalculator subtotalCalculator;
//
//    public Receipt settle(Cart cart)
//    {
//        Receipt receipt = new Receipt();
//        double tempSubtotal;
//        for (Item item : cart.getCartList()) {
//            tempSubtotal = subtotalCalculator.calculate(item);
//            ReceiptItem receiptItem =
//                    new ReceiptItem(item.getGood().getBarcode(), item.getGood().getPrice(), item.getCount(), tempSubtotal);
//            receipt.receiptItemList.add(receiptItem);
//            receipt.totalUpdate(tempSubtotal);
//        }
//        System.out.println(receipt);
//
//        return receipt;
//    }
}
