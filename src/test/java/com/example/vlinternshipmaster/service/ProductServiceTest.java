package com.example.vlinternshipmaster.service;

import com.example.vlinternshipmaster.product.Product;
import com.example.vlinternshipmaster.product.ProductDb;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Test
    public void shouldGetProductFromDatabaseByName(){

        ProductDb productDb = new ProductDb();

        Product product =  new Product("Milk", Product.Type.DAIRY, new BigDecimal("2.7"));

        var expectedProduct = productDb.getProduct(product.name());

        assertEquals(product.name(), expectedProduct.name());
        assertEquals(product.type(), expectedProduct.type());
        assertEquals(product.price(), expectedProduct.price());

    }
}
