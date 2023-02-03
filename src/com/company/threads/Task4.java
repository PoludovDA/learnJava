package com.company.threads;

class Chat {
    private boolean flag = false;
    public synchronized void question(String message) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        System.out.println(message);
        notify();
    }

    public synchronized void answer(String message) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        System.out.println(message);
        notify();
    }
}

class Questions implements Runnable {
    private Chat chat;
    String[] s1 = { "Привет", "Как ты ?", "Я тоже хорошо!" };
    Thread t;
    private String threadName;

    public Questions(Chat chat, String threadName) {
        this.chat = chat;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (String s : s1) {
            chat.question(s);
        }
    }

    public void start() {
        t = new Thread(this, threadName);
        System.out.println(threadName + " запускается");
        t.start();
    }
}

class Answers implements Runnable{
    private Chat chat;
    String[] s2 = { "Привет", " Я хорошо, как ты?", "Отлично!" };
    Thread t;
    private String threadName;

    public Answers(Chat chat, String threadName) {
        this.chat = chat;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (String s : s2) {
            chat.answer(s);
        }
    }

    public void start() {
        t = new Thread(this, threadName);
        System.out.println(threadName + " запускается");
        t.start();
    }
}

public class Task4 {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Questions questions = new Questions(chat, "Поток вопросов");
        Answers answers = new Answers(chat, "Поток ответов");
        questions.start();
        answers.start();
    }
}
