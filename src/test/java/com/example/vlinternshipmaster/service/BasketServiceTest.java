package com.example.vlinternshipmaster.service;

import com.example.vlinternshipmaster.basket.Basket;
import com.example.vlinternshipmaster.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {


    @Test
    public void givenProductToAddThenShouldAddTheProduct(){

        Basket basket = new Basket();

        Product product = new Product("Egg", Product.Type.DAIRY,new BigDecimal(1));
        basket.addProduct(product);

        Optional<Product> optional = basket.getProducts().stream().filter(product1 -> product1.name().equals(product.name())).findFirst();

        assertEquals(optional.get().name() , product.name());
        assertEquals(optional.get().price(), product.price());



    }

}
