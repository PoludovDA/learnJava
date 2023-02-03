package com.company.stringTasks;

public class StringMethods {
    public static String getMostLengthStr(String[] array) {
        int maxLength = 0;
        String maxString = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                maxString = s;
            }
        }
        return maxString;
    }

    public static Boolean isPalindrom(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.toLowerCase());
        return stringBuffer.reverse().toString().equals(str.toLowerCase());
    }

    /**
     * Меняет букву а на хуй
     */
    public static String replaceACock(String str) {
        return str.replaceAll("а", "хуй");
    }

    public static int countSubString(String str, String sub) {
        int count = 0;
        int countChar = 0;
        char[] strArr = str.toCharArray();
        char[] subArr = sub.toCharArray();
        for (int i = 0; i <= strArr.length - sub.length(); i++) {
            countChar = 0;
            if (strArr[i] == subArr[0]) {
                for (int j = 0; j < subArr.length; j++) {
                    if (strArr[i + j] == subArr[j]) {
                        countChar++;
                        if(countChar == sub.length())
                            count++;
                    }
                    else
                        break;
                }
            }

        }
        return count;
    }
}
