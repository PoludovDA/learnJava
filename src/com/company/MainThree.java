package com.company;

public class MainThree {
    public static void main(String[] args) {
        char[] str = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' '};
        char[] res = getReplacedChars(str);
        System.out.println(str);
        System.out.println(res);
    }

    private static char[] getReplacedChars(char[] str) {
        char s1 = '%';
        char s2 = '2';
        char s3 = '0';

        char[] result;
        int count = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                count++;
            }
        }
        result = new char[str.length + count * 2];

        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                result[j] = s1;
                result[j + 1] = s2;
                result[j + 2] = s3;
                j += 3;
                continue;
            }
            result[j] = str[i];
            j++;
        }
        return result;
    }
}
