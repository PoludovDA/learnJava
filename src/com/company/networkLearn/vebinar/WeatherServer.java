package com.company.networkLearn.vebinar;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class WeatherServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12201);
            System.out.println("Ждем подключения...");
            while (true)
                try (Phone phone = new Phone(server)){
                    String town = phone.reader();
                    if (town.equals("Выход"))
                        break;
                    int temp = (int) (Math.random() * 30) - 20;
                    phone.write(String.format("В городе %s температура: %d", town, temp));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
