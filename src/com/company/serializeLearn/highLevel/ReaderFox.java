package com.company.serializeLearn.highLevel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReaderFox {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src\\com\\company\\serializeLearn\\highLevel\\foxes.bin"))){
            Fox[] foxes = (Fox[]) ois.readObject();
            System.out.println(Arrays.toString(foxes));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
