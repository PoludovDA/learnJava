package com.company.networkLearn.vebinar;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class VebServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket( 12200)){
            System.out.println("Server started");
            while (true)
                try (Socket socket = serverSocket.accept();
                     BufferedWriter writer = new BufferedWriter(
                             new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(socket.getInputStream())
                     )
                ){
                    System.out.println("Client connected: " + socket.getInetAddress());
                    String request = reader.readLine();
                    writer.write("Hello, I'm server " + request.length());
                    writer.newLine();
                    writer.flush();
                }
                catch (NullPointerException e) {
                    System.out.println("На сервер не пришли данные");
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
