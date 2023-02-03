package com.company.inetShop.core;

import lombok.Value;

import java.util.LinkedList;

@Value
public class Basket {
    LinkedList<Product> chooseProductList;

    public Basket(LinkedList<Product> chooseProductList) {
        this.chooseProductList = chooseProductList;
    }
}
