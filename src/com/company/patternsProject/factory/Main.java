package com.company.patternsProject.factory;

/**
 * Паттерн фабрика. Цель - интерфейс, который будет создавать объект. Какой класс будет у этих объектов
 * скрыто для пользователя.
 * Интерфейс Developer реализуют классы различных разработчиков, у всех один метод - написать код
 * Интерфейс DeveloperFactory содержит метод createDeveloper, который реализуют классы JavaDeveloperFactory,
 * CppDeveloperFactory и PhpDeveloperFactory. Каждый из этих классов создает объект разработчика своего типа.
 * Здесь статичная функция по строковому параметру возвращает объект того разработчика, название которого
 * мы передали этой функции строкой. С помощью строкового параметра можно создавать различные классы.
 * Помещая в аргумент различные языки программирования мы будем создавать объекты разных разработчиков.
 */
public class Main {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpec("cpp");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpec(String speciality) {
        switch (speciality) {
            case "java":
                return new JavaDeveloperFactory();
            case "cpp":
                return new CppDeveloperFactory();
            case "php":
                return new PhpDeveloperFactory();
            default:
                throw new RuntimeException(speciality + " is unknown");
        }
    }
}
