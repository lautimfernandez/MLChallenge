package com.example.mlchallenge.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void getPriceFormated() {
        float price = 99999.49f;
        Product mockedProduct = new Product();
        mockedProduct.setPrice(price);
        assertEquals(mockedProduct.getPriceFormated(), "99.999,5");
    }
}