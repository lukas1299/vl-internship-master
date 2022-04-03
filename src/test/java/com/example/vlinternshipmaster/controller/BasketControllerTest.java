package com.example.vlinternshipmaster.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BasketControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldAddProductToBasketAndGetProductsFromBasket() throws Exception{

        mvc.perform(post("/app/basket/addToBasket?name=Apple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());


        mvc.perform(get("/app/basket/getProductsFromBasket")).andExpect(status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
               .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Is.is("Apple")));


    }
    @Test
    public void shouldGetProductFromDataBase() throws Exception {

        mvc.perform(get("/app/getProductFromDataBase?name=Apple"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.name",Is.is("Apple")));


    }


}


