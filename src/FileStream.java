import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileStream {
    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//
//        fileInputStream = new FileInputStream("src\\input.txt");
//        fileOutputStream = new FileOutputStream("src\\output.txt");
//        int a = 0;
//        try {
//            while ((a = fileInputStream.read()) != -1) {
//                fileOutputStream.write(a);
//            }
//        } catch (IOException ex) {
//            System.out.println("Соси");
//        }
//        finally {
//            fileInputStream.close();
//            fileOutputStream.close();
//        }

        /**
         * Рандомные буквы англ в выходном файле
         */
//        FileOutputStream fileOutputStream1 = null;
//        int[] arrayRand = new int[100];
//        for (int i = 0; i < arrayRand.length; i++) {
//            arrayRand[i] = (int) (Math.random() * 25) + 97;
//        }
//        try {
//            fileOutputStream1 = new FileOutputStream("src\\randText.txt");
//            for (int i = 0; i < arrayRand.length; i++) {
//                fileOutputStream1.write(arrayRand[i]);
//            }
//        }
//        catch (IOException ex) {
//            System.out.println("Соси");
//        }
//        finally {
//            fileOutputStream1.close();
//        }

        InputStreamReader instre = null;
        try {
            instre = new InputStreamReader(System.in);
            System.out.println("Вводите символы, символ q для выхода из потока:\n");
            char a;
            do{
                a = (char) instre.read();
                System.out.println(a);
            }
            while (a != 'q');
        }
        finally {
            if(instre != null)
                instre.close();
        }

        /**
         * Запись строки в файл и вывод содержимого файла в консоль
         */
//        String str = "hui malafia";
//        char[] strCharArray = str.toCharArray();
//        FileOutputStream fileOutputStream = null;
//        Writer w = null;
//        try {
//            fileOutputStream = new FileOutputStream("src\\strFile.txt");
//            w = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
//            w.write(str);
//            w.close();
//            InputStream inputStream = new FileInputStream("src\\strFile.txt");
//            for (int i = 0; i < inputStream.available(); i++) {
//                System.out.print((char) inputStream.read());
//            }
//            inputStream.close();
//        } catch (IOException ex) {
//            System.out.println("Соси");
//        }
        /**
         * mkdir() - создание папки (относительный путь корня проекта)
         * mkdirs() - создание папок по пути (абсолютный путь)
         */
//        File file = new File("/training/fitness/gay");
//        System.out.println(file.mkdirs());

//        File file1 = new File("src/javaGay");
//        System.out.println(file1.mkdir());
        /**
         * Получить список файлов в этом каталоге
         */
//        File pathDir = null;
//        String[] fileList;
//        try {
//            pathDir = new File("C:\\Users\\polud\\IdeaProjects\\learnJava\\src");
//            fileList = pathDir.list();
//            for (String s : fileList)
//                System.out.println(s);
//        }
//        catch (Exception ex) {
//            System.out.println("Соси");
//            ex.printStackTrace();
//        }
        /**
         * Классы ByteArrayInputStream и ByteArrayOutputStream
         */
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
//        byteArrayOutputStream.write("Hello".getBytes());
//
//        byte[] a = byteArrayOutputStream.toByteArray();
//        System.out.println("Вывод содержимого: ");
//        for (byte b : a) {
//            System.out.println((char)b);
//        }
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a);
//        int b;
//        while ((b = byteArrayInputStream.read()) != -1) {
//            System.out.print(Character.toUpperCase((char) b));
//        }
//        byteArrayInputStream.reset();
//        byteArrayOutputStream.close();
//        byteArrayInputStream.close();

        /**
         * Классы DataOutputStream и DataInputStream мспользуются для записи
         * и чтения примитивных типов данных
         */
//        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src\\input.txt"));
//        dataOutputStream.writeUTF("Залупа пенис");
//        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src\\input.txt"));
//        while (dataInputStream.available() > 0) {
//            System.out.println(dataInputStream.readUTF());
//        }

        //Для примера записать массив чисел и вывести
//        int[] a = new int[] {34, 228, 1890};
//        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src\\input.txt"));
//        for (int i : a) {
//            dataOutputStream.writeInt(i);
//        }
//        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src\\input.txt"));
//        while (dataInputStream.available() > 0)
//            System.out.println(dataInputStream.readInt());

        /**
         * FileReader и FileWriter для чтения/записи поток символов
         */
        File file = new File("src\\hui.txt");
        System.out.println(file.createNewFile());
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("huiiiiii");
        fileWriter.append(" pisun");
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        int a = 0;
        char[] b = new char[200];
//        fileReader.read(b); //чтение в массив
        while ((a = fileReader.read()) != -1) {
            System.out.print((char) a);
        }
        fileReader.close();
    }
}
