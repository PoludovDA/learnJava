package com.company.threads;

import java.io.*;

/**
 * Чтобы потоки могли обращать к объекту только по очереди, а не одновременно
 * его нужно облачить в synchronized. Объект может быть чем угодно (любым классом, файлом и т.д.)
 */
class ReaderNumbers implements Runnable{
    private final File file;
    private String threadName;
    Thread t;

    public ReaderNumbers(File file, String threadName) {
        this.file = file;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        synchronized (file) {
            try (FileInputStream in = new FileInputStream(file)) {
                for (int i = 0; i < in.available(); i++) {
                    System.out.println(in.read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        t = new Thread(this, threadName);
        System.out.println("******************************************\nЗапуск " + threadName);
        t.start();
    }
}

class RighterNumbers extends Thread {
    private final File file;
    private int count;
    private String threadName;
    Thread t;

    public RighterNumbers(File file, int count, String threadName) {
        this.file = file;
        this.count = count;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        synchronized (file) {
            try (FileOutputStream out = new FileOutputStream(file)) {
                for (int i = count; i < 101; i += count) {
                    out.write(i);
                    System.out.println(threadName + " записал в файл число " + i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        t = new Thread(this, threadName);
        System.out.println("Запуск потока " + threadName);
        t.start();
    }
}

public class Task3 {
    public static void main(String[] args) {
        File file = new File("src\\com\\company\\threads\\numbers.txt");
        RighterNumbers thread1 = new RighterNumbers(file, 2, "Поток двоичный");
        RighterNumbers thread2 = new RighterNumbers(file, 3, "Поток троичный");
        ReaderNumbers thread3 = new ReaderNumbers(file, "Поток чтения");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
