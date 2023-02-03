package com.company.collectionLearn;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа без пробелов через запятую: ");
        String input = scanner.next();
        String[] inputArr = input.split(",");
        Set set = new HashSet();
        for (String s : inputArr) {
            set.add(Integer.parseInt(s));
        }
        scanner.close();
        System.out.println(set);
    }
}
