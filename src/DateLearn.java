import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateLearn {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString() + "\nвремя в милисекундах с 1 " +
                "января 1970 года: " + date.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("G E W yyyy:HH:mm");
        System.out.println(simpleDateFormat.format(date));

        /**
         * Вывод даты доступен также через принтф. Таблицу с форматами можно
         * подсмотреть на проглэнг
         */
        System.out.printf("%s %te %<tB %<tY", "Сегодняшняя дата:", date);

        String str = "12-09-2019";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        Date date1;
        try {
            date1 = simpleDateFormat1.parse(str);
            System.out.println("\n" + simpleDateFormat1.format(date1) + " день недели: "
            + new SimpleDateFormat("EEEE").format(date1));
        }
        catch (ParseException ex) {
            System.out.println("\nНе удалось распарсить дату с помощью " + simpleDateFormat1);
        }



        /**
         * Вместо Thread.sleep() лучше использовать это
         */
//        try {
//            System.out.println(new Date());
//            TimeUnit.SECONDS.sleep(3);
//            TimeUnit.MICROSECONDS.sleep(3000000);
//            TimeUnit.MILLISECONDS.sleep(2000);
//            System.out.println(new Date());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        /**
         * Расчет разницы между датами в днях, на примере сколько мне дней
         */
        String format = "dd-MM-yyyy";
        SimpleDateFormat myBirthdayFormat = new SimpleDateFormat(format);
        String birthday = "19-07-1998";
        String today = myBirthdayFormat.format(new Date());
        long millis = 0;

        try {
            millis = myBirthdayFormat.parse(today).getTime() - myBirthdayFormat.parse(birthday).getTime();
        } catch (ParseException ex) {
            System.out.println("Не получилось распарсить дату с форматом: " + format);
        }
        int meDays = (int) (millis / (1000 * 60 * 60 * 24));
        System.out.println("Мне " + meDays + " дней");

        /**
         * Засечь время работы программы на примере вывода ста рандомных чисел
         */
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println("Число " + i + ": " + (int) (Math.random() * 10));
        }
        long timeWork = System.currentTimeMillis() - start;
        System.out.println("Время вывода десяти тысяч рандомных чисел: " + timeWork + "мс");

        /**
         * Для того чтобы удобно было вычитать дни из даты воспользуемся классом LocalDate
         * Вместо SimpleDateFormat используется DateTimeFormatter
         */
        LocalDate localDate = LocalDate.now().minusDays(30);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
        System.out.println(localDate.format(dateTimeFormatter));
        /**
         * В качестве примера: из даты 19.07.1998 вычесть количество моих дней и вывести новую дату
         */
        String myBirthDate = "19.07.1998";
        System.out.println("Мой день рождения: " + myBirthDate);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        Date myBd = null;
        LocalDate beforeMeLocalDate = null;
        Date beforeMeDate = null;
        try {
            myBd = simpleDateFormat2.parse(myBirthDate);
            beforeMeLocalDate = myBd.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
                    .minusDays(meDays);
            beforeMeDate = simpleDateFormat3.parse(beforeMeLocalDate.toString());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Минус от моего др сколько дней я прожил: " + simpleDateFormat2.format(beforeMeDate));

        /**
         * Так же можно сделать все в классе Date
         */
        Date date2 = new Date();
        date2.setHours(-meDays * 24);
        System.out.println(simpleDateFormat2.format(date2));
    }
}
