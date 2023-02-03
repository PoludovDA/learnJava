package com.company.lambdaLearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Пример как можно использовать лямбду. Компаратор в методе Collections.sort()
 *
 */
public class Task4 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Пашок", 25, 1, 9.8, 'm'));
        students.add(new Student("Никита", 20, 3, 7, 'm'));
        students.add(new Student("Рита", 22, 2, 6.1, 'f'));
        students.add(new Student("Денис", 24, 1, 6.4, 'm'));
        students.add(new Student("Алия", 27, 4, 6.9, 'f'));

        students.forEach(System.out::println);
        System.out.println("\n\n Отсортированные студенты: ");
        Collections.sort(students, (s1, s2) -> s1.age - s2.age);
        students.forEach(System.out::println);
    }
}
