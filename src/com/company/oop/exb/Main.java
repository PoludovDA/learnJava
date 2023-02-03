package com.company.oop.exb;

import java.util.Arrays;
import java.util.Scanner;;

public class Main {
    public static void main(String[] args) {
        Train[] trainList = new Train[5];
        trainList[0] = new Train("Новая Каховка", 228, "06:20");
        trainList[1] = new Train("Москва", 26, "18:20");
        trainList[2] = new Train("Санкт-Петербург", 56, "01:40");
        trainList[3] = new Train("Сызрань", 3, "16:56");
        trainList[4] = new Train("Сызрань", 12, "10:18");

        Arrays.sort(trainList, new Train.StringComparator());
        for (Train t : trainList)
            t.print();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер интересуемого поезда: ");
        int num = scanner.nextInt();
        scanner.close();

        for (Train t : trainList) {
            if (t.getNumber() == num)
                t.print();
        }
    }
}
