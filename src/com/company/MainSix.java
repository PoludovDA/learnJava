package com.company;

import java.util.logging.Logger;

public class MainSix {
    protected static final Logger log = Logger.getLogger(MainSix.class.getName());
    public static void main(String[] args) {
        char a = 'f';
        Character b = 'r';
        char tab = '\t';
        String omega = "\uD83D\uDE08";
        log.info(omega);
        System.out.println("Она сказала \"Привет!\" мне.");
    }
}
