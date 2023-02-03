package com.company.networkLearn.vebinar;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12200);
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Client connected");
            writer.write("Samara");
            writer.newLine();
            writer.flush();

            System.out.println("Request: " + reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
