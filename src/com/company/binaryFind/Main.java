package com.company.binaryFind;

import java.util.Arrays;

/**
 * Проверить входит ли в массив данный элемент
 */
public class Main {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        int N = 1000;
        int element = 36;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) Math.round(Math.random() * 1000);
        }

        startTime = System.nanoTime();
        bubbleSort(arr);
        endTime = System.nanoTime();
        System.out.println("Время сортировки пузырьком: " + (endTime - startTime));
        System.out.println(Arrays.binarySearch(arr, element));

        startTime = System.nanoTime();
        Boolean isElInArr = isElementInArrayPerebor(arr, element);
        endTime = System.nanoTime();
        System.out.println("Элемент найден: " + isElInArr);
        System.out.println("Время поиска перебором: " + (endTime - startTime));

        startTime = System.nanoTime();
        Boolean isFound = binaryFind(arr, element);
        endTime = System.nanoTime();
        System.out.println("Элемент найден: " + isFound);
        System.out.println("Время двоичного поиска : " + (endTime - startTime));
    }

    private static Boolean isElementInArrayPerebor(int[] array, int number) {
         for (int i = 0; i < array.length; i++) {
             if (array[i] == number)
                 return true;
         }
         return false;
    }

    private static Boolean binaryFind(int[] array, int number) {
        if(array.length == 1) {
            return array[0] == number;
        }
        else if(number == array[array.length/2])
            return true;
        else if (number < array[array.length / 2]) {
            return binaryFind(Arrays.copyOfRange(array, 0, array.length/2), number);
        }
        else
            return binaryFind(Arrays.copyOfRange(array, array.length/2, array.length), number);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
