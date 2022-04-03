package com.example.vlinternshipmaster.sevice;

import com.example.vlinternshipmaster.basket.Basket;
import com.example.vlinternshipmaster.product.Product;
import com.example.vlinternshipmaster.product.ProductDb;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    Basket basket = new Basket();

    public void addProduct(Product product){
        basket.addProduct(product);
    }
    public Basket getBasket(){
        return basket;
    }

}
