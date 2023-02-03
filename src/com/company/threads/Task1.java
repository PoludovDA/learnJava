package com.company.threads;

class ThreadDemo implements Runnable{

    private int count;

    private String threadName;

    public ThreadDemo(int count, String threadName) {
        System.out.printf("Создание потока %s\n", threadName);
        this.count = count;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.printf("Поток %s: %d\n", threadName, i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }

    public String getThreadName() {
        return threadName;
    }
}

public class Task1 {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo(40, "Первый");
        ThreadDemo threadDemo1 = new ThreadDemo(44, "Второй");
        Thread t1 = new Thread(threadDemo, threadDemo.getThreadName());
        Thread t2 = new Thread(threadDemo1, threadDemo1.getThreadName());
        t1.start();
        t2.start();
    }
}
