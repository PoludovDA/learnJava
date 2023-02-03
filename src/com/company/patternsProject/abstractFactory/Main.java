package com.company.patternsProject.abstractFactory;

import com.company.patternsProject.abstractFactory.banking.BankTeamFactory;
import com.company.patternsProject.abstractFactory.webSite.WebTeamFactory;

/**
 * Паттерн абстрактная фабрика используется для создания множества взаимосвязанных объектов.
 * В этом примере: создан интерф для девелопера с методом writeCode, тестера - test, ПМа - controlProcess
 * В интерфейсе TeamFactory объявлены методы для создания разных работников (команды)
 * В пакетах banking и webSite все эти интерфейсы реализованы и имплементированы соответственно.
 * В пакете banking работники работают с банком, в пакете webSite с веб сайтом, поэтому работники содержат
 * разные методы. Плюс этого паттерна в том, что можно сразу просто создать всю команду через интерфейс TeamFactory
 * полиморфизмом инициализировать его в нужный класс (например для банка - BankTeamFactory) и уже из этого
 * класса получить разработчика, тестировщика и пиэма. Они все будут банковскими работниками, то есть их методы
 * будут для работы с банком.
 */
public class Main {
    public static void main(String[] args) {
        TeamFactory teamFactory = new BankTeamFactory();
        Developer developer = teamFactory.getDeveloper();
        Tester tester = teamFactory.getTester();
        ProjectManager projectManager = teamFactory.getProjectManager();

        System.out.println("Разработка банка началась...");
        developer.writeCode();
        tester.test();
        projectManager.controlProcess();

        TeamFactory teamFactory1 = new WebTeamFactory();
        Developer developer1 = teamFactory1.getDeveloper();
        Tester tester1 = teamFactory1.getTester();
        ProjectManager projectManager1 = teamFactory1.getProjectManager();

        System.out.println("Разработка веб сайта началась...");
        developer1.writeCode();
        tester1.test();
        projectManager1.controlProcess();
    }
}
