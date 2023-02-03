package com.company.serializeLearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Так как массив это тоже объект, то можно записывать/считывать функциями writeObject/readObject сразу весь массив
 * в файле
 */
public class ReaderArrayClass {
    public static void main(String[] args) {
        List<Person> outputPeople = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\com\\company\\serializeLearn\\people.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            int countPeople = objectInputStream.readInt();
            for (int i = 0; i < countPeople; i++) {
                outputPeople.add((Person) objectInputStream.readObject());
            }
            System.out.println("Количество людей: " + countPeople + " Список: " + outputPeople.toString());
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
