import java.io.*;

public class ExceptionLearn {
    public static void main(String[] args) {
        /**
         * Неконтролируемое исключение то что не подчеркивает айдия. Ошибки во время выполнения программы
         * Эти исключения можно выбрасывать через throw без throws
         */

        int[] array = new int[] {2, 4};
        try {
            System.out.println(array[2]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Вышли за пределы массива " + ex.getCause());
//            throw ex;
        }
        finally {
            System.out.println(array[0]);
            System.out.println("Блок finally выполнился");
        }

        /**
         * Конструкция try-with-resources автоматически (без блока finally) закрывает все ресурсы (потоки)
         * может быть передано несколько классов через ;
         */
        try (FileWriter fileWriter = new FileWriter("src\\input.txt");
             FileReader fileReader = new FileReader("src\\hui.txt")) {
            char[] a = new char[40];
            fileReader.read(a);
            for (char s : a) {
                System.out.print(s);
            }
            fileWriter.write(a);
        }
        catch (IOException ex) {
            System.out.println("Соси");
            ex.printStackTrace();
        }
        System.out.println();
        System.out.println("Я на ваше исключение хуй ложил");


    }
}
