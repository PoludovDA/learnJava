package com.company.serializeLearn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class WriterArrayClass {
    public static void main(String[] args) {
        Person[] people = new Person[] {new Person("Ivan", 1), new Person("Dmitriy", 2),
                                        new Person("Denis", 3), new Person("Gay", 7)};
        try {
            FileOutputStream fos = new FileOutputStream("src\\com\\company\\serializeLearn\\people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //Запишем сначала количество объектов в файл
            oos.writeInt(people.length);
            for(Person p : people) {
                oos.writeObject(p);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
