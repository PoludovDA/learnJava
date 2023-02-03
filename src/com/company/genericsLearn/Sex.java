package com.company.genericsLearn;

import com.company.oop.exa.Student;

import java.io.Serializable;

public class Sex <T extends Comparable, V extends Number & Serializable, K extends Student> {
    private T t;
    private V v;
    private K k;

    public Sex(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public void printTypes() {
        System.out.println(t.getClass().getName());
        System.out.println(v.getClass().getName());
        System.out.println(k.getClass().getName());
    }

    public static void main(String[] args) {
        Sex<String, Integer, Student> stud = new Sex<>("Гей", 69, new Student("Залупкин Вадим", 2));
        stud.printTypes();
    }
}
