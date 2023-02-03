package com.company.collectionLearn;

public class StudentA {
    private String fullName;
    private int groupNumber;
    private int course = 1;
    private int[] marks;

    public StudentA(String fullName, int groupNumber) {
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
        System.out.println("Имя: " + fullName + " Курс: " + course + " Номер группы: " + groupNumber);
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCourse() {
        return course;
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
