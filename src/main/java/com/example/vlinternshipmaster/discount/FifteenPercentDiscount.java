package com.example.vlinternshipmaster.discount;


import com.example.vlinternshipmaster.product.Product;
import com.example.vlinternshipmaster.receipt.Receipt;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class FifteenPercentDiscount {

    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {

        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        AtomicInteger counter = new AtomicInteger();

        receipt.entries().forEach(receiptEntry -> {
            if(receiptEntry.product().type() == Product.Type.GRAINS) counter.getAndIncrement();
        });

        return counter.get() >= 3;
    }
}
