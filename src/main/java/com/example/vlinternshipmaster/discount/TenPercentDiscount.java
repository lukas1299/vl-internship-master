package com.example.vlinternshipmaster.discount;


import com.example.vlinternshipmaster.receipt.Receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TenPercentDiscount {

    public static String NAME = "TenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.9));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        return receipt.totalPrice().compareTo(BigDecimal.valueOf(50)) >= 0;
    }
}
