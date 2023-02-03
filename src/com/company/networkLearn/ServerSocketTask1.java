package com.company.networkLearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTask1 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)){
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Enter you're command:");
            while (scanner.hasNextLine()) {
                String inputStr = scanner.nextLine();
                writer.println("You send: " + inputStr);
                System.out.println(inputStr);
                if (inputStr.equals("exit"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
