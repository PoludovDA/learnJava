package com.company.serializeLearn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriterClass {
    public static void main(String[] args) {
        Person person1 = new Person("Denis", 69);
        Person person2 = new Person("Masha", 228);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\com\\company\\serializeLearn\\people.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person2);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
