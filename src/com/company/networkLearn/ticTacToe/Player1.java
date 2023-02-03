package com.company.networkLearn.ticTacToe;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Player1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String HOST = "localhost";
        int PORT = 8187;
        TicField ticField = null;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner cinScanner = new Scanner(System.in)){

            System.out.println("Player connected");
            String num;
            while (reader.ready()) {
                String str = reader.readLine();
                if (str.startsWith("Победитель")) {
                    System.out.println(str);
                    break;
                }
                System.out.print(str);
                num = cinScanner.nextLine();
                writer.write(num);
                writer.newLine();
                writer.flush();

                System.out.print(reader.readLine());
                num = cinScanner.nextLine();
                writer.write(num);
                writer.newLine();
                writer.flush();

                Thread.sleep(1000);
                System.out.println(reader.readLine());
                System.out.println(reader.readLine());
                System.out.println(reader.readLine());
            }
        }
    }
}
