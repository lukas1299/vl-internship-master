package com.example.vlinternshipmaster.controller;

import com.example.vlinternshipmaster.product.Product;
import com.example.vlinternshipmaster.receipt.Receipt;
import com.example.vlinternshipmaster.receipt.ReceiptGenerator;
import com.example.vlinternshipmaster.sevice.BasketService;
import com.example.vlinternshipmaster.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/app")
public class BasketController {

    ProductService productService;
    BasketService basketService;

    @Autowired
    public BasketController(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;
    }

    @GetMapping("/getProductFromDataBase")
    public Product getProductFromDb(@RequestParam(name = "name") String name){
        return productService.getProduct(name);
    }

    @PostMapping("/basket/addToBasket")
    public void addProductToBasket(@RequestParam(name = "name") String name ){

        basketService.addProduct(getProductFromDb(name));
    }

    @GetMapping("/basket/getProductsFromBasket")
    public List<Product> getProductFromBasket(){
        return basketService.getBasket().getProducts();
    }

    @GetMapping("/basket/generateReceipt")
    public Receipt getGeneratedReceipt(){

        return new ReceiptGenerator().generate(basketService.getBasket());
    }

}
