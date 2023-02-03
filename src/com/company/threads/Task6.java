package com.company.threads;

class CoolThread implements Runnable{
    private String threadName;

    public CoolThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Task6 {
    public static void main(String[] args) {
        CoolThread coolThread1 = new CoolThread("Поток-1");
        CoolThread coolThread2 = new CoolThread("Поток-2");
        Thread thread1 = new Thread(coolThread1);
        Thread thread2 = new Thread(coolThread2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
//            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
