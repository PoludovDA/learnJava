package com.company.oop.exa;

public class Main {
    public static void main(String[] args) {
        Student[] studentList = new Student[10];
        studentList[0] = new Student("Горшок КИШ", 1);
        studentList[1] = new Student("Пугачева А.Б.", 1);
        studentList[2] = new Student("Кирюшин Т.Ц.", 1);
        studentList[3] = new Student("Лепс Водка", 1);
        studentList[4] = new Student("Шарлот Педик", 1);
        studentList[5] = new Student("Полюдов Verblud", 2);
        studentList[6] = new Student("Грим Борис", 2);
        studentList[7] = new Student("Сюткин Валерий", 2);
        studentList[8] = new Student("Клава Cockа", 2);
        studentList[9] = new Student("Майкл Джексон", 2);

        for (Student s : studentList) {
            s.setMarks(getRandMarks());
            if (s.isBotan())
                s.print();
        }
    }

    private static int[] getRandMarks() {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) Math.round(Math.random() * 2) + 8;
        }
        return a;
    }
}
