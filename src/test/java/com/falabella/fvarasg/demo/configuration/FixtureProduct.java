package com.falabella.fvarasg.demo.configuration;

import com.falabella.fvarasg.demo.model.Product;

import java.util.List;

public class FixtureProduct {

    public static final Long SKU = 1L;
    public static final String NAME = "TV";
    public static final String BRAND = "LG";
    public static final String SIZE = "1000";
    public static final String PRICE = "20000";
    public static final String IMAGES = "http://imagublic";
    public static final String SUCCES_STATUS = "Succes";
    public static final String SUCCES_CODE = "200 OK";
    public static final String OK = "OK";

    public static Product products() {

        return Product.builder()
                .sku(SKU)
                .name(NAME)
                .brand(BRAND)
                .size(SIZE)
                .price(PRICE)
                .principalImage(IMAGES)
                .build();
    }

    public static List<Product> productList(){
        return List.of(products());
    }

}
