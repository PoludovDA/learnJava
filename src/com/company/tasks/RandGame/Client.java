package com.company.tasks.RandGame;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 10100);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner cinScanner = new Scanner(System.in)) {

            System.out.println("Player connected");

            while (true) {
                String in = reader.readLine();
                System.out.println(in);
                Thread.sleep(2000);
                while (reader.ready()) {
                    in = reader.readLine();
                    System.out.println(in);
                    Thread.sleep(1000);
                }
                if (in.startsWith("Абсолютный"))
                    break;
                String out = cinScanner.nextLine();
                writer.write(out);
                writer.newLine();
                writer.flush();
            }
            System.out.println("Игра окончена");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
