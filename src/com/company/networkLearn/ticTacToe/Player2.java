package com.company.networkLearn.ticTacToe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Player2 {
    public static void main(String[] args) {
        String HOST = "localhost";
        int PORT = 8187;
        try {
            Socket socket = new Socket(HOST, PORT);

            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
