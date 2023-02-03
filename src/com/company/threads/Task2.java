package com.company.threads;

class DemoThread extends Thread {

    private Thread t;
    private int count;
    private String nameThread;

    public DemoThread(int count, String nameThread) {
        this.count = count;
        this.nameThread = nameThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.printf("Поток %s: %d\n", nameThread, i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        t = new Thread(this, nameThread);
        t.start();
        System.out.println("Поток " + nameThread + " запущен");
    }
}

public class Task2 {
    public static void main(String[] args) {
        DemoThread demoThread1 = new DemoThread(20, "Копейка");
        DemoThread demoThread2 = new DemoThread(20, "Газ-21");
        demoThread1.start();
        demoThread2.start();
    }
}
