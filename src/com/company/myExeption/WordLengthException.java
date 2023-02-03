package com.company.myExeption;

public class WordLengthException extends Exception{
    private int dif;

    public WordLengthException(String message, int dif) {
        super(message + dif);
        this.dif = dif;
    }

    public int getDif() {
        return dif;
    }
}
