package com.company.streamLearn;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Стримы коллекций
 * Есть терминальные операции - которые закрывают стрим после себя, такие как forEach
 */
public class Task2 {
    public static void main(String[] args) {
        List<Slave> slaves = new ArrayList<>();
        slaves.add(new Slave("Мария", 69, 23, Post.WORKER));
        slaves.add(new Slave("Денис", 228, 24, Post.WORKER));
        slaves.add(new Slave("Ильнур", 22, 36, Post.WORKER));
        slaves.add(new Slave("Александр", 12, 29, Post.BOSS));
        slaves.add(new Slave("Игорь", 42, 30, Post.CLEANER));
        slaves.add(new Slave("Надежда", 88, 25, Post.CLEANER));
        slaves.add(new Slave("Юрий", 4, 42, Post.BOSS));
        slaves.add(new Slave("Сергей", 127, 45, Post.WORKER));
        slaves.add(new Slave("Антонина", 2, 62, Post.CLEANER));
        slaves.add(new Slave("Антон", 19, 37, Post.BOSS));
        slaves.add(new Slave("Иван", 33, 39, Post.BOSS));
        slaves.add(new Slave("Владимир", 186, 18, Post.CLEANER));
        slaves.add(new Slave("Григорий", 48, 33, Post.WORKER));
        slaves.add(new Slave("Павел", 114, 19, Post.WORKER));

        //Параллельный стрим для многопоточности (делать на небольшой коллекции нецелесообразно)
        Stream<Slave> slaveStream = slaves.stream();
        Stream<Slave> slaveParStream = slaves.parallelStream();

        slaves.forEach(slave -> System.out.println(slave.getAge()));
        slaves.stream().forEachOrdered(slave -> System.out.println(slave.getAge()));
        //Число объектов в стриме
        System.out.println("\n\n" + slaveStream.count());

        //Приведение стримов к листу и массиву
//        Slave[] array = (Slave[]) slaves.stream().toArray();
        List<Slave> slList = slaves.stream().collect(Collectors.toList());
        //К мапе: первая лямбда ключ, вторая значение
        HashMap<Integer, String> slavesMap = (HashMap <Integer, String>) slaves.stream().collect(Collectors.toMap(
                Slave::getId, slave -> String.format("Имя: %s", slave.getName())));

        //Найти максимальный возраст
        System.out.println("Самому старому сотруднику: " + slaves.stream().max(Comparator.comparingInt(Slave::getAge)).orElse(new Slave(null, 0, 0, null)).toString());

        //Однопоточный стрим: оба метода вернут первый элемент
        //Многопоточный: findAny вернет один произвольный элемент, findFirst - гарантиованно первый
        System.out.println(slaves.stream().findAny());
        System.out.println(slaves.stream().findFirst());

        //Булевы значения из стримов или проверки
        System.out.println("Ни одному сотруднику нет больше 60 лет: " +
                slaves.stream().noneMatch(slave -> slave.getAge() > 60));
        System.out.println("Есть хотя бы одна уборщица: " +
                slaves.stream().anyMatch(slave -> slave.getRole() == Post.CLEANER));
        System.out.println("Всем сотрудникам есть 18: " +
                slaves.stream().allMatch(slave -> slave.getAge() >= 18));

        //Метод filter - отфильтрованный стрим. В него войдут только те объекты,
        //которые соответствуют условию в лямбда выражении
        Stream<Slave> bitchSlaves = slaves.stream().filter(slave -> slave.getRole() != Post.BOSS);
        System.out.println("Сотрудники не являющиеся начальниками: ");
        bitchSlaves.forEach(System.out::println);

        //skip(a) пропустить первые а элементов, limit(b) взять только первые b элеметов
        Stream<Slave> small = slaves.stream()
                .skip(3)
                .limit(5);
        System.out.println("\nОбрезанный стрим:");
        small.forEach(System.out::println);

        //peek - то же что map, чаще используется когда надо установить какое нибудь значение объекта
        System.out.println("\n5 самых молодых сотрудников с именем измененным на Лариса с помощью" +
                "\nmap переведенные из Slave в String строку в которой содержится полная информация о них");
        slaves.stream()
                .sorted(Comparator.comparingInt(Slave::getAge))
                .limit(5)
                .peek(slave -> slave.setName("Лариса"))
                .map(slave -> String.format("Имя: %s, id: %d, возраст: %d, должность: %s",
                        slave.getName(), slave.getId(), slave.getAge(), slave.getRole().getName()))
                .forEach(System.out::println);

        //Методы takeWhile и dropWhile появились с java 9
        //Первый записывает в стрим объекты, пока условие выполняется
        //Второй начинает записывать как только встретиться объект не выполняющий условие
//        slaves.stream().takeWhile(slave -> slave.getAge() < 30).forEach(System.out::println);
//        slaves.stream().dropWhile(slave -> slave.getAge() < 30).forEach(System.out::println);

        System.out.println("\nВывести сотрудников старше 30, отсортированных по грейду");
        Stream<Slave> task = slaves.stream()
                .filter(slave -> slave.getAge() >= 30)
                .sorted(Comparator.comparingInt(slave -> Integer.parseInt(slave.getRole().getName().split(" ")[2])));
        printStreamSlave(task);

        System.out.println("\n4 самых старых сотрудника, отсортированных по имени");
        Stream<Slave> task2 = slaves.stream()
                .sorted((slave1, slave2) -> slave2.getAge() - slave1.getAge())
                .limit(4)
                .sorted(Comparator.comparing(Slave::getName));
        printStreamSlave(task2);

        System.out.println("\nПолучить стрим чисел (возраст сотрудников) и получить статистику");
        String ageStatistics = slaves.stream()
                .mapToInt(Slave::getAge)
                .summaryStatistics()
                .toString();

        System.out.println(ageStatistics);
    }

    public static void printStreamSlave(Stream<Slave> stream) {
        stream
                .map(slave -> String.format("Имя: %s, id: %d, возраст: %d, должность: %s",
                        slave.getName(), slave.getId(), slave.getAge(), slave.getRole()))
                .forEach(System.out::println);

    }
}
