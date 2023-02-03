package com.company.stringTasks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] sArr = new String[] {"Говно", "Залупа", "Пенис", "Хер", "Давалка", "Хуй"};
        System.out.println(StringMethods.getMostLengthStr(sArr));


        String s = "Шалаш";
        System.out.println(StringMethods.isPalindrom(s));

        String s1 = "Я не буду нукогда сосать пенис залупы";
        System.out.println(StringMethods.replaceACock(s1));

        String s2 = "Писька на сиське, а сиська на писькеись ";
        System.out.println(StringMethods.countSubString(s2, "ись"));
    }
}
