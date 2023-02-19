package com.company.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Вернуть сумму диагоналей матрицы
 * 1.Квадратная
 * 2.Элементы от 1 до 100
 * 3.Центральный элемент если он общий для диагоналей считается один раз
 */
public class MatrixTask {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.ceil(Math.random() * 20);
            System.out.print(arr[i] + ", ");
        }
        bubbleSort(arr);
        System.out.println("");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
}
