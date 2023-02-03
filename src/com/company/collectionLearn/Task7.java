package com.company.collectionLearn;

import java.util.HashMap;
import java.util.Map;

public class Task7 {
    public static void main(String[] args) {
        Map<String, Toy> toys = new HashMap<>();
        toys.put("Жираф", new Toy(600, "Плюшевый"));
        toys.put("Солдатик", new Toy(200, "Оловянный"));
        toys.put("Меч", new Toy(400, "Деревянный"));
        toys.put("Новогодний шар", new Toy(160, "Стеклянный"));

        printEntrySet(toys);
        System.out.println("*******************************");
        printKeySet(toys);
        System.out.println("*******************************");
        printValuesCollection(toys);
    }

    private static void printEntrySet(Map map) {
        map.entrySet().forEach(System.out :: println);
    }

    private static void printKeySet(Map map) {
        map.keySet().forEach(System.out :: println);
    }

    private static void printValuesCollection(Map map) {
        map.values().forEach(System.out :: println);
    }
}
