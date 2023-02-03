package com.company.patternsProject.singleton;

/**
 * Паттерн синглетон (одиночка)
 * Цель: гарантия что у класса будет единственный экземпляр с глобальным доступом.
 * В данном примере как синглетон описан логгер. Более подробно как работает смотри в классе ProgramLogger.
 */
public class Main {
    public static void main(String[] args) {
        ProgramLogger.getProgramLogger().addLog("я гей");
        ProgramLogger.getProgramLogger().addLog("ты гей");
        ProgramLogger.getProgramLogger().addLog("что мы медлим?");
        ProgramLogger.getProgramLogger().showLogs();

        System.out.println(ProgramLogger.getProgramLogger());

        //Это один и тот же файл:
        System.out.println(ProgramLogger.getProgramLogger());
        System.out.println(ProgramLogger.getProgramLogger());
        System.out.println(ProgramLogger.getProgramLogger());
        System.out.println(ProgramLogger.getProgramLogger());
    }
}
