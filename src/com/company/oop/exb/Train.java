package com.company.oop.exb;


import java.util.Comparator;

/**
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда,
 * время отправления. Создайте массив из пяти элементов типа Train, добавьте возможность
 * сортировки элементов массива по номерам поездов. Добавьте возможность вывода информации
 * о поезде, номер которого введен пользователем, добавьте возможность сортировки массива по
 * пункту назначения, причем поезда с одинаковым пунктом назначения должны быть упорядочены по времени отправления.
 */
public class Train {
    private String goTo;
    private int number;
    private String timeStart;

    public Train(String goTo, int number, String timeStart) {
        this.goTo = goTo;
        this.number = number;
        this.timeStart = timeStart;
    }

    public static class NumberComparator implements Comparator<Train> {
        @Override
        public int compare(Train t1, Train t2) {
            if (t1.number == t2.number)
                return 0;
            else if (t1.number < t2.number)
                return -1;
            else
                return 1;
        }
    }

    public static class StringComparator implements Comparator<Train> {
        @Override
        public int compare(Train t1, Train t2) {
            if (t1.goTo.equals(t2.goTo))
                return t1.timeStart.compareTo(t2.timeStart);
            return t1.goTo.compareTo(t2.goTo);
        }
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Train{" +
                "goTo='" + goTo + '\'' +
                ", number=" + number +
                ", timeStart='" + timeStart + '\'' +
                '}';
    }
}
