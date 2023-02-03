package com.company.inetShop;

import com.company.inetShop.core.Basket;
import com.company.inetShop.core.Category;
import com.company.inetShop.core.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.company.inetShop.Shop.*;
import static com.company.inetShop.User.printProductsUser;

public class Main {
    public static void main(String[] args) throws NotFoundException {
        Scanner scanner = new Scanner(System.in);
        User user = Steps.login(scanner);
        Steps.shopProcess(user, scanner);
        scanner.close();

        System.out.println("Товары которые купила Маша: ");
        printProductsUser(user);
    }

    private static void printCatalog(List<Category> categories) {
        categories.forEach(Category::printProductList);
    }


}
