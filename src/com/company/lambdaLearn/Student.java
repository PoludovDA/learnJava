package com.company.lambdaLearn;

public class Student {
    String name;
    int age;
    int course;
    double averageG;
    char sex;

    public Student(String name, int age, int course, double averageG, char sex) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.averageG = averageG;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", averageG=" + averageG +
                ", sex=" + sex +
                '}';
    }
}
