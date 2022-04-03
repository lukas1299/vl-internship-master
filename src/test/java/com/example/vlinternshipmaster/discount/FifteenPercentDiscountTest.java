package com.example.vlinternshipmaster.discount;


import com.example.vlinternshipmaster.product.Product;
import com.example.vlinternshipmaster.product.ProductDb;
import com.example.vlinternshipmaster.receipt.Receipt;
import com.example.vlinternshipmaster.receipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FifteenPercentDiscountTest {

    @Test
    void shouldApply15PercentDiscountWhenNumberOfGrainsIsAbove3() {
        // Given
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        var cereals2 = productDb.getProduct("Cereals");

        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        receiptEntries.add(new ReceiptEntry(bread, 1));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        receiptEntries.add(new ReceiptEntry(cereals2, 1));


        var receipt = new Receipt(receiptEntries);
        var discount = new FifteenPercentDiscount();

        var expectedGrainsQuantity = 0;

        for (ReceiptEntry i : receipt.entries()) {
            expectedGrainsQuantity += (i.product().type() == Product.Type.GRAINS) ? 1 : 0;
        }


        // When
        var receiptAfterDiscount = discount.apply(receipt);

        // Then
        assertEquals(expectedGrainsQuantity, 3);
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldNotApply15PercentDiscountWhenNumberOfGrainsIsBelow3() {
        // Given
        var productDb = new ProductDb();
        var cereals = productDb.getProduct("Cereals");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cereals, 2));

        var receipt = new Receipt(receiptEntries);
        var discount = new TenPercentDiscount();

        var expectedGrainsQuantity = 0;

        for (ReceiptEntry i : receipt.entries()) {
            expectedGrainsQuantity += (i.product().type() == Product.Type.GRAINS) ? 1 : 0;
        }

        // When
        var receiptAfterDiscount = discount.apply(receipt);

        // Then
        assertEquals(expectedGrainsQuantity, 1);
        assertEquals(0, receiptAfterDiscount.discounts().size());
    }
}
