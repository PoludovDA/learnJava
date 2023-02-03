package com.company.patternsProject.builder;

/**
 * Реализация: класс билдер - внутренний статичный класс. В основном классе достаточно объявить поля
 * и конструктор который принимает объект билдера. В билдере указать поля, которые мы хотим строить
 * и сгенерировать сеттеры к этим полям, тип возвращения которых будет объект типа билдер. Таким образом
 * мы можем вызывать сеттеры билдера через точку. В конце метод билд завершающий цепочку должен возвращать
 * объект основного класса и в его конструктор передать наш билдер.
 */
public class Student {
    private String name;
    private int course;
    private int id;
    private Brain brain;

    private Student(StudentBuilder studentBuilder) {
        name = studentBuilder.name;
        course = studentBuilder.course;
        id = studentBuilder.id;
        brain = studentBuilder.brain;
    }

    static class StudentBuilder {
        private String name;
        private int course;
        private int id;
        private Brain brain;

        public StudentBuilder addName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder addCourse(int course) {
            this.course = course;
            return this;
        }

        public StudentBuilder addId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder addBrain(Brain brain) {
            this.brain = brain;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", id=" + id +
                ", brain=" + brain +
                '}';
    }
}

enum Brain {
    STUPID, NORMAL, GENIUS;
}
