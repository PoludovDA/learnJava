package com.company.streamLearn;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Slave {
    private String name;
    private int id;
    private int age;
    private Post role;

    @Override
    public String toString() {
        return "Имя " + name +
                ", возраст " + age;
    }
}

enum Post {
    CLEANER("Уборщик грейд 1"),
    WORKER("Работник грейд 2"),
    BOSS("Начальник грейд 3");

    private final String s;

    Post(String s) {
        this.s = s;
    }

    public String getName() {
        return this.s;
    }
}

