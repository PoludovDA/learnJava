package com.company.tasks.RandGame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerRandGame {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(10100);){
            System.out.println("Waiting connection...");
            while (true)
                try (Socket socket = serverSocket.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    System.out.println("Connected: " + socket.getInetAddress());

                    List<Player> players = ServerSteps.initPlayers(writer, reader);
                    while (players.size() > 1) {
                        int number = ServerSteps.setNumber(writer);
                        int cash = ServerSteps.setCash(players, writer, reader);
                        if (cash == 0)
                            continue;
                        ServerSteps.stepGame(players, number, cash, writer, reader);
                    }
                    writer.write("Абсолютный чемпион: " + players.get(0).toString());
                    writer.newLine();
                    writer.flush();
                }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
