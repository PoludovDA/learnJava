package com.company.lambdaLearn;

import java.util.concurrent.Callable;

/**
 * Callable - стандартный функциональный интерфейс
 * Можно также использовать в потоках, так как интерфейс Runnable содержит один абстрактный метод run()
 */
public class Task5 {
    public static void main(String[] args) {
        Callable<Integer> c = () -> 42;


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
            System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
