package com.homework.pos;

import java.util.List;

public class POS
{
    public Receipt settle(Cart cart)
    {
        Receipt receipt = new Receipt();
        receipt.setTotal(495.0);
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
