package com.example.vlinternshipmaster.sevice;

import com.example.vlinternshipmaster.product.Product;
import com.example.vlinternshipmaster.product.ProductDb;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductDb productDb = new ProductDb();

    public Product getProduct(String name){return productDb.getProduct(name);}


}
