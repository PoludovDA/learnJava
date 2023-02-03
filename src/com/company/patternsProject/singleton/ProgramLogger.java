package com.company.patternsProject.singleton;

/**
 * У класса единственный конструктор - пустой приватный. Таким образом экземпляр этого класса мы сделать не можем извне.
 * К единственному экземпляру можно обращаться с помощью статичного метода getProgramLogger
 * он synchronized так как чтобы этот экземпляр мог использоваться в многопоточных приложениях.
 * Здесь логи записываются в статичную переменную logFile. Увидеть их можно с помощью статичного метода showLogs.
 * Так как мы не можем создавать экземпляр этого класса все нужные извне методы и переменные должны быть static.
 */
public class ProgramLogger {
    private static String logFile = "This is logFile: \n\n";
    private static ProgramLogger programLogger;

    private ProgramLogger() {

    }

    public static synchronized ProgramLogger getProgramLogger() {
        if (programLogger == null)
            programLogger = new ProgramLogger();
        return programLogger;
    }

    public void addLog(String log) {
        logFile += log + "\n";
    }

    public void showLogs() {
        System.out.println(logFile);
    }
}
