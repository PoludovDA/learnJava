package com.company.inetShop.core;

import lombok.Value;

@Value
public class Product {
    String name;
    int cost;
    double rating;

    public Product(String name, int cost, double rating) {
        this.name = name;
        this.cost = cost;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Название: '" + name + '\'' +
                ", Цена: " + cost +
                ", Рейтинг: " + rating;
    }
}
