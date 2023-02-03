package com.company.myExeption;

public class Main {
    public static void main(String[] args) throws WordLengthException, NoRussianLetterException {
        RussianLetters rl = null;
        try {
            rl = new RussianLetters("Поси");
            rl.concat("вывшшшшшшшшшшшшшшшшшеовмдоауыслшнннн");
        }
        catch (NoRussianLetterException | WordLengthException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        System.out.println(rl.getStr());
    }
}
