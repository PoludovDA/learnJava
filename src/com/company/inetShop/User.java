package com.company.inetShop;

import com.company.inetShop.core.Basket;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

@Data
public class User {
    String login;
    String password;
    Basket hisBasket = new Basket(new LinkedList<>());

    public User(String login, String password) throws NotFoundException {
        try{
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("com\\company\\inetShop\\users.properties"));
            if (System.getProperty(login) != null) {
                this.login = login;
            }
            else
                throw new NotFoundException("Не существует пользователя с логином: ", login);
            if (password.equals(System.getProperty(login))) {
                this.password = password;
            }
            else
                throw new NotFoundException("Неверный пароль: ", password);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Привет, " + this.login + "!");
    }

    public static void printProductsUser(User user) {
        user.hisBasket.getChooseProductList().forEach(System.out :: println);
    }
}
