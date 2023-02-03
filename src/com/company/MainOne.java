package com.company;

public class MainOne {
    public static void main(String[] args) {
        double[] arr = new double[100];
        double max = 0;
        double min = 1;
        double avg = 0;

        for (int i = 0; i < arr.length; i++)
            arr[i] = Math.random();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (min > arr[i])
                min = arr[i];
            avg+=arr[i] / arr.length;
        }
        System.out.println("Макс "+ max);
        System.out.println("Мин " + min);
        System.out.println("Сред "+ avg);
    }
}
