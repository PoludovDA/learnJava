package com.company.myExeption;

public class NoRussianLetterException extends Exception{
    private String str;

    public NoRussianLetterException(String str) {
        this.str = str;
    }

    public NoRussianLetterException() {
        super();
    }

    public String getStr() {
        return str;
    }
}
