package com.company.lambdaLearn;

import java.util.ArrayList;

/**
 * Отфильтровать студентов с помощью анонимного класса определяющего интерфейс
 * метод checkS (метод определяющий по какому признаку фильтруем студентов) каждый раз определяется
 * как мы хотим в виде анонимного класса
 * то же самое что и Task1.
 *
 * Здесь же лямбда выражение. Оно состоит из списка параметров -> тело реализованного абстрактного метода
 * возвращаемый тип абстрактного метода должен совпадать с типом метода в лямбда выражении.
 */
class InfoStudent {
    public static void printStudents(ArrayList<Student> al, CheckStudents cs) {
        for (Student s : al) {
            if (cs.checkS(s))
                System.out.println(s);
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Пашок", 25, 1, 9.9, 'm'));
        students.add(new Student("Никита", 20, 3, 7, 'm'));
        students.add(new Student("Рита", 22, 2, 6.2, 'f'));
        students.add(new Student("Денис", 24, 1, 6.4, 'm'));
        students.add(new Student("Алия", 27, 4, 6.9, 'f'));

        InfoStudent.printStudents(students, new CheckStudents() {
            @Override
            public boolean checkS(Student student) {
                return student.age > 23;
            }
        });
        System.out.println("****************");
        /**
         * Лямбду потренируем на Пашке. Базовый полный тип лямбды
         */
        InfoStudent.printStudents(students, (Student s) -> {return s.averageG > 7.5;});

        /**
         * Теперь самое короткое лямбда выражение. Здесь у параметра не указывается тип параметра, так как джава знает
         * какой тип параметра указан в анонимном методе. Без фигурных скобках сразу тело метода то что должно вернуться
         */
        InfoStudent.printStudents(students, student -> student.averageG > 7.5);
        /**
         * Так как функция имеет в аргументе интерфейс, можно создать этот объект как лямбда выражение
         */
        CheckStudents cs = student -> student.averageG > 7.5;
        InfoStudent.printStudents(students, cs);

        System.out.println("*****************");
        InfoStudent.printStudents(students, new CheckStudents() {
            @Override
            public boolean checkS(Student student) {
                return student.age > 25 && student.sex == 'f';
            }
        });
    }
}

interface CheckStudents {
    boolean checkS(Student student);
}