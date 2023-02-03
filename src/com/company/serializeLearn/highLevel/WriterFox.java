package com.company.serializeLearn.highLevel;

import com.company.serializeLearn.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriterFox {
    public static void main(String[] args) {
        Fox fox1 = new Fox("Alice", 122, new Person("Oleg", 1));
        Fox fox2 = new Fox("Larisa", 128, new Person("Anna", 2));
        Fox[] foxes = new Fox[] {fox1, fox2};

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src\\com\\company\\serializeLearn\\highLevel\\foxes.bin"))){
//            oos.writeObject(fox1);
//            oos.writeObject(fox2);
            oos.writeObject(foxes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
