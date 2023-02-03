package com.company.serializeLearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderClass {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\com\\company\\serializeLearn\\people.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person person1 = (Person) objectInputStream.readObject();
            Person person2 = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(person1);
            System.out.println(person2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
