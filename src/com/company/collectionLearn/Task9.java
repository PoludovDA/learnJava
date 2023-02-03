package com.company.collectionLearn;

import java.util.HashMap;
import java.util.Map;

public class Task9 {
    public static void main(String[] args) {
        Map<String, Pet> pets = new HashMap<>();
        pets.put("Герцог", new Cat());
        pets.put("Дружок", new Dog());
        pets.put("Буренка69", new Cow());
        pets.put("Филимон", new Cat());

        pets.values().forEach(Pet::voice);
        //Отобразить все ключи:
        pets.keySet().forEach(System.out :: println);
    }
}
