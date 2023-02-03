package com.company.oop.exa;

/**
 * Создайте класс с именем StudentA, содержащий поля: фамилия и инициалы, номер группы,
 * успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа.
 * Добавьте возможность вывода фамилии и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Student {
    private String fullName;
    private int groupNumber;
    private int[] marks;

    public Student(String fullName, int groupNumber) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        marks = new int[5];
    }

    public boolean isBotan() {
        for (int i : marks) {
            if (i < 9)
                return false;
        }
        return true;
    }

    public boolean isNormal() {
        double average = 0.0;
        for (int mark : marks) {
            average += (double) mark / marks.length;
        }
        return average >= 9.0;
    }

    public void print() {
        System.out.println("Имя: " + fullName + " Номер группы: " + groupNumber);
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int[] getMarks() {
        return marks;
    }
}
