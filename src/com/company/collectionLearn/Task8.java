package com.company.collectionLearn;

import com.company.oop.exa.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        StudentA[] studentList = new StudentA[10];
        studentList[0] = new StudentA("Горшок КИШ", 1);
        studentList[1] = new StudentA("Пугачева А.Б.", 1);
        studentList[2] = new StudentA("Кирюшин Т.Ц.", 1);
        studentList[3] = new StudentA("Лепс Водка", 1);
        studentList[4] = new StudentA("Шарлот Педик", 1);
        studentList[5] = new StudentA("Полюдов Verblud", 2);
        studentList[6] = new StudentA("Грим Борис", 2);
        studentList[7] = new StudentA("Сюткин Валерий", 2);
        studentList[8] = new StudentA("Клава Cockа", 2);
        studentList[9] = new StudentA("Майкл Джексон", 2);

        List<StudentA> students = new ArrayList(Arrays.asList(studentList));
        System.out.println("Студенты до экзаменов: ");
        students.forEach(StudentA::print);
        setMarks(students);


        printBadStudents(students);
        students = filterBadStudent(students);

        System.out.println("Студенты после экзаменов: ");
        students.forEach(StudentA::print);
    }

    private static void printBadStudents(List<StudentA> students) {
        List<StudentA> bad = students.stream().filter(x-> !x.isNormal()).collect(Collectors.toList());
        System.out.println("Студенты на отчисление: ");
        bad.forEach(x-> System.out.println(x.getFullName()));
    }

    private static List<StudentA> filterBadStudent(List<StudentA> students) {
//        students.stream().forEach(x-> System.out.println("Студент " + x.getFullName()
//                + " перешел на следующий курс: " + x.isNormal()));
        students.forEach(x-> x.setCourse(x.getCourse() + 1));
        return students.stream().filter(StudentA::isNormal).collect(Collectors.toList());
    }

    private static int[] getRandMarks() {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) Math.round(Math.random() * 2) + 8;
        }
        return a;
    }

    private static void setMarks(List<StudentA> students) {
        for (StudentA s : students) {
            s.setMarks(getRandMarks());
        }
    }
}
