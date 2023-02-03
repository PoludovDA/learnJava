package com.company.serializeLearn.highLevel;

import com.company.serializeLearn.Person;

import java.io.Serializable;

/**
 * serialVersionUID - автогенерирующееся поле, генерировать каждый раз при изменении класса.
 * В случае попытки десериализации объекта класс которого с момента его сериализации устарел
 * (например появились новые поля, изменились имена старых полей и т.д.) данная ошибка
 * будет выводиться наглядно. Serializable - интерфейс не имеющий методов, его имплементация
 * по сути флажок что объекты этого класса являются сериализуемыми.
 * transient - пометка что данное поле не является сериализуемым, то есть, поля с этой пометкой
 * будут сериализоваться как null или в случае примитивных типов данных как 0.
 */
public class Fox implements Serializable {
    private static final long serialVersionUID = -3737576680513605041L;
    private String name;
    private transient Integer id;
    private Person owner;

    public Fox(String name, Integer id, Person owner) {
        this.name = name;
        this.id = id;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Fox{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", owner=" + owner +
                '}';
    }
}
