package com.company.patternsProject.builder;

/**
 * Цель: более наглядно конструировать объект. Можно добавлять и необязательные поля
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder()
                .addName("Залупкин")
                .addId(228)
                .addCourse(2)
                .addBrain(Brain.STUPID)
                .build();

        System.out.println(student);
    }
}
