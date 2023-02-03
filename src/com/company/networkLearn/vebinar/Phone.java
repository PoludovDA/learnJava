package com.company.networkLearn.vebinar;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Phone implements Closeable {
    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Phone(String host, int port) {
        try {
            socket = new Socket(host, port);
            reader = createReader();
            writer = createWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Phone(ServerSocket server) {
        try {
            socket = server.accept();
            reader = createReader();
            writer = createWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String str) {
        try {
            writer.write(str);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String reader() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    @Override
    public void close() throws IOException {
        socket.close();
        reader.close();
        writer.close();
    }
}
