package com.company.networkLearn.ticTacToe;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class TicServer {
    public static void main(String[] args) {
        int PORT = 8187;
        ServerSocket serverSocket = null;
        TicField ticField = null;

        try {
            serverSocket = new ServerSocket(PORT, 2);
            System.out.println("Waiting for connection");

            while (true)
                try (Socket socket = serverSocket.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                    System.out.println("Connected: " + socket.getInetAddress());
                    ticField = new TicField();
                    String raw = null, column = null;
                    while (!ticField.isEnd()) {
                        writer.write("Игрок 1, введите номер строки: ");
                        writer.newLine();
                        writer.flush();

                        raw = reader.readLine();
                        writer.write("Игрок 1, введите номер столбца: ");
                        writer.newLine();
                        writer.flush();

                        column = reader.readLine();
                        ticField.setTic(Integer.parseInt(raw), Integer.parseInt(column), "krestik");
                        writer.write(ticField.toString());
                        writer.flush();
                        System.out.println(ticField);
                        ticField.checkEndGame();
                        if (ticField.isEnd())
                            continue;

                        writer.write("Игрок 2, введите номер строки: ");
                        writer.newLine();
                        writer.flush();

                        raw = reader.readLine();
                        writer.write("Игрок 2, введите номер столбца: ");
                        writer.newLine();
                        writer.flush();

                        column = reader.readLine();
                        ticField.setTic(Integer.parseInt(raw), Integer.parseInt(column), "nolik");
                        writer.write(ticField.toString());
                        writer.flush();
                        System.out.println(ticField);
                        ticField.checkEndGame();
                    }

                    writer.write("Победитель: " + ticField.getWinner());
                    writer.newLine();
                    writer.flush();
                } catch (SocketException e) {
                    System.out.println("Ошибка соединения");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
