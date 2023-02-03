package com.company.lambdaLearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Отфильтровать студентов по простому:
 */
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Пашок", 25, 3, 9.9, 'm'));
        students.add(new Student("Никита", 20, 2, 7, 'm'));
        students.add(new Student("Рита", 22, 1, 6.2, 'f'));
        students.add(new Student("Денис", 24, 2, 6.4, 'm'));
        students.add(new Student("Алия", 27, 4, 6.9, 'f'));

        FilterStudent fs = new FilterStudent();
        fs.checkAgeMore(students, 23);
        System.out.println("******************");
        fs.checkAverageMoreThan(students, 7.5);
        System.out.println("******************");
        fs.checkCondition(students, 25, 'f');
    }
}

class FilterStudent {
    public void checkAverageMoreThan(ArrayList<Student> al, double averageG) {
        for(Student s : al) {
            if (s.averageG > averageG)
                System.out.println(s);
        }
    }

    public void checkAgeMore(ArrayList<Student> al, int age) {
        for(Student s : al) {
            if (s.age > age)
                System.out.println(s);
        }
    }

    public void checkCondition(ArrayList<Student> al, int age, char sex) {
        for(Student s : al) {
            if (s.age > age && s.sex == sex)
                System.out.println(s);
        }
    }
}
