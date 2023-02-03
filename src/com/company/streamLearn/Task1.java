package com.company.streamLearn;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Какими бывают стримы:
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        //Стрим содержащий список строк из файла
        Stream<String> fileLines = Files.lines(Paths.get("src\\input.txt"));
        //Стрим из списка объектов и директории
        Stream<Path> paths = Files.list(Paths.get("/"));
        //Стрим из папок/объектов из директории. Уровень погружения (количество дочерних папок)
        Stream<Path> walks = Files.walk(Paths.get("/"), 3);

        //Для примитивных типов данных стрим можно создать так:
        IntStream numbers = IntStream.of(5, 3, 4, 2, 1);
        DoubleStream numbers2 = DoubleStream.of(2.4, 2.0, 5.1);
        //от 10 до 99
        IntStream ranges = IntStream.range(10, 100);
        //от 10 до 100
        IntStream ranges2 = IntStream.rangeClosed(10, 100);

        //Создать стрим из массива
        int[] nums = {4, 90, 3160};
        IntStream stream = Arrays.stream(nums);
        //Создать стрим из билдера
        Stream<String> strs = Stream.<String>builder()
                .add("Говно")
                .add("Залупа")
                .add("Член")
                .build();
        //Создать стрим из любого типа данных
        Stream<? extends Number> numbs = Stream.of(16, 22, 9.94);
        //Или
        Stream<?> others = Stream.of("Горщок", 228, 'e', 4.69);

        //Стрим из функции, поток создается в момент обращения к нему
        Stream<Event> generator = Stream.generate(() -> new Event(UUID.randomUUID(), LocalDateTime.now().getHour(), ""));
        //Поток из текущей даты
        Stream<LocalDate> timeStream = Stream.generate(LocalDate::now);
        //Стрим итератор (Начальное значение, итерация)
        Stream<Integer> iterator = Stream.iterate(69, v -> v + 2);
        //Объединение стримов. Второй добавляется после первого
        Stream<Number> all = Stream.concat(numbs, iterator);

        //Метод reduce - (Все объекты до следующего, следующий) на примере суммы всех чисел
        System.out.println("Сумма: " + IntStream.of(256, 228, 674, 244).reduce((left, right) -> left += right).getAsInt());
        //Статистики чисел. Стрим после одного использования закрывается, поэтому нужно создать новый
        IntStream num1 = IntStream.of(256, 228, 674, 244);
        System.out.println("max: " + num1.max().orElse(0));
        System.out.println("min: " + IntStream.of(256, 228, 674, 244).min().getAsInt());
        System.out.println("average: " + IntStream.of(256, 228, 674, 244).average().orElse(0));
        System.out.println("statistics: " + IntStream.of(256, 228, 674, 244).summaryStatistics().toString());

        //Метод map - вернуть стрим с любыми типами данных
        //Изменить тип данных с инта на лонг
        LongStream ls = IntStream.of(33, 3, 1090).mapToLong(i -> (long) i); //или
        LongStream ls1 = IntStream.of(33, 3, 1090).mapToLong(Long::valueOf);
        //Получить стрим дат с отнятыми днями из стрима инт
        Stream<LocalDate> sd = IntStream.of(100, 200, 4).mapToObj(value -> LocalDate.now().minusDays(value));
        System.out.println("Даты с отнятыми днями:");
        sd.forEach(System.out::println);

        //Метод distinct уберет повторяющиеся объекты из стрима
        IntStream setsNumbers = IntStream.of(1, 2, 3, 3, 2).distinct();
        setsNumbers.forEach(System.out::println);


    }
}
