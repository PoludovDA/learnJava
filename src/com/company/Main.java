package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        int[] randArray = new int[10];
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = (int) Math.round(Math.random() * 100);
        }
        //4, 8, 5
        int pred;
        int count;
        do {
            pred = 0;
            count = 0;
            for (int i = 0; i < randArray.length; i++) {
                if (randArray[i] < pred) {
                    count++;
                    for (int j = 0; j < randArray.length; j++) {
                        if (j == i - 1) {
                            randArray[j] = randArray[i];
                            randArray[i] = pred;
                        }
                    }
                }
                pred = randArray[i];
            }
        } while (count > 0);
        Arrays.stream(randArray).forEach(System.out::println);
        int sum = 0;
        for (int i : randArray)
            sum+= i;
        System.out.println("Максимальное значение: " + randArray[randArray.length - 1] + "\n" +
                "Минимальное значение: " + randArray[0] + "\n" +
                "Медианное значение: " + randArray[(int) randArray.length/2] + "\n" +
                "Среднее арифметическое: " + (int)sum/randArray.length);
    }
}
