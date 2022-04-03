package com.example.vlinternshipmaster.receipt;

import com.example.vlinternshipmaster.basket.Basket;
import com.example.vlinternshipmaster.discount.FifteenPercentDiscount;
import com.example.vlinternshipmaster.discount.TenPercentDiscount;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        AtomicInteger counter = new AtomicInteger();

        //I set the quantity of products as a constant 2
        basket.getProducts().forEach(product -> receiptEntries.add(counter.getAndIncrement(),new ReceiptEntry(product,2)));

        Receipt finalRecipet = new Receipt(receiptEntries);
        finalRecipet = new FifteenPercentDiscount().apply(finalRecipet);
        finalRecipet = new TenPercentDiscount().apply(finalRecipet);

        return finalRecipet;
    }
}
