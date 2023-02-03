package com.company.lambdaLearn;

/**
 * Еще один пример
 */
public class Task3 {
    public static void main(String[] args) {
        int a = 5;
        doAnother("Привеееет", s -> s.length() + 5 + a);
        System.out.println("************************");
        /**
         * Если больше одно параметра в методе, то надо писать их в круглых скобках.
         * Если в теле метода кроме ретерн есть еще какая строчка, то писать нужно полный вариант
         */
        doAnother("Здарова", s -> {
            System.out.println("Рукоблуд!");
            return s.length();
        });
        System.out.println("****************");
        /**
         * Если у абстрактного метода нет параметров, его аргументы обозначаются как ()
         */
        doStr(() -> 18);
    }

    static void doAnother(String s, I i) {
        System.out.println(i.test(s));
    }

    static void doStr(NoParams np) {
        System.out.println(np.check());
    }
}

interface I {
    int test(String str);
}

interface NoParams {
    int check();
    /**
     * Так же нельзя использовать переменные извне в лямбда выражениях, если они меняются, то есть не константы.
     * Или не final
     */
}