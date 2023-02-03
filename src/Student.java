class Student {
    int age = 11;
    Student() {
        System.out.println("Соси");
    }

    Student(int age) {
        this.age = age;
    }

    protected int maxCig(String mark, int... counts) {
        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            max = Math.max(max, counts[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.age);
        Student student1 = new Student(28);
        System.out.println(student1.age);
        System.out.println(student.maxCig("Malboro", 12, 14, 4, 6));
    }
}