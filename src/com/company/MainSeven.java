package com.company;

public class MainSeven {
    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("I love ");
        str.append("cocks");
        str.reverse();
        System.out.println(str);

        String s = str.toString();

        StringBuffer sb = new StringBuffer();
        sb.append(s);
    }
}
