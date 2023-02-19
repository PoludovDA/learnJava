package com.company.myExeption;

public class WordLengthException extends Exception{
    private static final long serialVersionUID = -7373667158376399207L;
    private final int dif;

    public WordLengthException(String message, int dif) {
        super(message + dif);
        this.dif = dif;
    }

    public int getDif() {
        return dif;
    }
}
