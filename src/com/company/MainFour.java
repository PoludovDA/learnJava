package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFour {
    public static void main(String[] args) {
        Boolean isDeleteble;
        for (int i = 2; i <= 100; i++) {
            isDeleteble = false;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isDeleteble = true;
                    break;
                }
            }
            if (!isDeleteble)
                System.out.println(i);
        }
        String[] array = new String[]{"foo", "bar", "baz"};

        List<String> list = new ArrayList<>(Arrays.asList(array));
        list.remove("foo");
    }
}
