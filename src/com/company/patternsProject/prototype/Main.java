package com.company.patternsProject.prototype;

/**
 * Цель: создание клонов любых объектов с помощью созданного интерфейса с методом Object copy()
 */
public class Main {
    public static void main(String[] args) {
        Cow cow = new Cow("Буренка69", 228, 4);
        System.out.println(cow + "\n");
        //Простое клонирование. Есть минус: без приведения типа не работает
        Cow cow1 = (Cow) cow.copy();
        System.out.println(cow1 + "\n");
        //Клонирование через фабрику - приведение типа не нужно
        CowFactory cowFactory = new CowFactory(cow);
        Cow cow2 = cowFactory.createCloneCow();
        System.out.println(cow2);
    }
}
//for git