package com.company.genericsLearn;

public class Calculator {
    public static <K extends Number, V extends Number> double sum(K k, V v) {
        return k.doubleValue() + v.doubleValue();
    }

    public static <K extends Number, V extends Number> double minus(K k, V v) {
        return k.doubleValue() - v.doubleValue();
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 5;
        System.out.println(Calculator.minus(a, b));
    }
}
