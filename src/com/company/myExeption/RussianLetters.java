package com.company.myExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RussianLetters {
    private String str;
    private final Matcher matcher = null;
    private final int maxLength = 35;

    public RussianLetters(String str) throws NoRussianLetterException {
        String patternReg = "[А-я]+";
        Pattern pattern = Pattern.compile(patternReg);
        if (!pattern.matcher(str).matches()) {
            throw new NoRussianLetterException();
        }
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void concat(String str2) throws WordLengthException {
        if ((this.str + str2).length() > maxLength) {
            int dif = (this.str + str2).length() - maxLength;
            throw new WordLengthException("Количество лишних символов: ", dif);
        }
        this.str += str2;
    }
}
