package com.company.networkLearn.vebinar;

import java.io.IOException;
import java.util.Scanner;

public class WeatherClient {
    public static void main(String[] args) {
        try (Phone phone = new Phone("localhost", 12201);
             Scanner scanner = new Scanner(System.in)){

            System.out.print("Введите название города: ");
            String town = scanner.nextLine();

            phone.write(town);
            String response = phone.reader();
            System.out.printf("Ответ сервера: %s", response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
