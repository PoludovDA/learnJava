package com.company.inetShop;

import com.company.inetShop.core.Category;
import com.company.inetShop.core.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
    protected static Product vodka = new Product("5 озер", 500, 9.0);
    protected static Product beer = new Product("Балтика 9", 45, 6.0);
    protected static Product sidr = new Product("Мистер Лис", 69, 8.6);
    protected static Product vino = new Product("Таманская Гавань", 259, 8.4);

    protected static Product vedmak = new Product("Ведьмак", 800, 9.6);
    protected static Product harryPotter = new Product("Гарри Поттер", 700, 9.8);
    protected static Product kingRings = new Product("Властелин Колец", 1200, 9.4);

    protected static Product ciggaretes = new Product("Винстон", 160, 7.6);
    protected static Product snus = new Product("Снюс", 400, 5.6);

    protected static Category alco = new Category("Алкоголь", new Product[] {vodka, beer, sidr, vino});
    protected static Category books = new Category("Книги", new Product[] {vedmak, harryPotter, kingRings});
    protected static Category tabaco = new Category("Табак", new Product[] {ciggaretes, snus});

    protected static List<Category> catalog = new ArrayList<>(Arrays.asList(alco, books, tabaco));
}
