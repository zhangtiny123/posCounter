package com.homework.pos;

public class ConsolePrinter
{
    public static final String CONCLUSION_TITLE = "总计金额\t\t\t优惠前\t优惠后\t\t优惠差价";
    public static final String HEADER_TITLE = "购物明细\t\t\t数量\t\t单价\t\t\t小计";

    public void output(Receipt receipt)
    {
        System.out.println(HEADER_TITLE);
        for (ReceiptItem item : receipt.getReceiptItems()) {
            System.out.println(item.getBarcode() + "\t\t" + item.getCount() + "\t\t" + item.getPrice() + "\t\t" + item.getSubtotalPayments());
        }
        System.out.println(CONCLUSION_TITLE);
        System.out.println(receipt.getTotalPayments() + "\t\t\t" + receipt.getOriginTotalPayment() + "\t" + receipt.getTotalPayments() + "\t\t" + (receipt.getOriginTotalPayment()-receipt.getTotalPayments()));
    }
}
