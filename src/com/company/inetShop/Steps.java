package com.company.inetShop;

import com.company.inetShop.core.Basket;
import com.company.inetShop.core.Category;
import com.company.inetShop.core.Product;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Arrays;
import java.util.Scanner;

public class Steps {
    public static User login(Scanner scanner) throws NotFoundException {
        System.out.print("Введите логин: ");
        String login= scanner.next();
        System.out.print("Введите пароль: ");
        String password = scanner.next();

        User user = null;
        try {
            user = new User(login, password);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return user;
    }

    public static Category chooseCategory(Scanner scanner) throws NotFoundException {
        System.out.println("Что вы хотите: Алкоголь, Книги или Табак?");
        String category = scanner.next();
        for (Category cat : Shop.catalog) {
            if (cat.getName().equals(category)) {
                Arrays.stream(cat.getProductList()).forEach(x-> System.out.println(x.toString()));
                return cat;
            }
        }
        throw new NotFoundException("Не найден каталог: ", category);
    }

    public static void chooseProduct(Category category, User user, Scanner scanner) {
        System.out.println("Что вы хотите взять в корзину из категории " + category.getName() + "?");
        scanner.nextLine();
        String product = scanner.nextLine();
        for (Product p : category.getProductList()) {
            if (p.getName().equals(product)) {
                System.out.println("Добавить товар " + p.getName() + " в корзину? да/нет:");
                String chooseName = scanner.next();
                if (chooseName.equals("да")) {
                    user.hisBasket.getChooseProductList().addLast(p);
                    System.out.println("Товар " + p.getName() + " добавлен в корзину " + user.getLogin());
                    System.out.println("Корзина на данный момент: " + user.hisBasket.getChooseProductList());
                }
                break;
            }
        }
    }

    public static void shopProcess(User user, Scanner scanner) throws NotFoundException {
        System.out.println("Добро пожаловать в магазин Дениса!");
        String s = "да";

        while (s.equals("да")) {
            try {
                chooseProduct(chooseCategory(scanner), user, scanner);
                System.out.println("Хотите ли вы добавить в корзину что-то еще? да/нет");
                s = scanner.next();
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        System.out.println("Ваша корзина: " + user.hisBasket.getChooseProductList() + ". \nПокупаем? да/нет");
        s = scanner.next();
        if (s.equals("да"))
            System.out.println("Спасибо за покупку!");
        else
            System.out.println("Надеюсь в следующий раз будет что интересное!");
    }
}
