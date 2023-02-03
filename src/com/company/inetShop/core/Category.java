package com.company.inetShop.core;

import lombok.Value;

import java.util.Arrays;

@Value
public class Category {
    String name;
    Product[] productList;

    public Category(String name, Product[] productList) {
        this.name = name;
        this.productList = productList;
    }

    public void printProductList() {
        Arrays.stream(productList).forEach(System.out :: println);
    }
}
