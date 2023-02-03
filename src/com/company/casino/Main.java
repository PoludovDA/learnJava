package com.company.casino;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {
    public static void main(String[] args) {
        Casino casino = new Casino(11000, 10000);
        System.out.println(casino.getMyJackpot());

//        int i = 0;
//        int loh = 0;
//        int mid = 0;
//        int win = 0;
//        while (i < 100) {
//            String res = casino.getMyJackpot();
//            if (res.contains("дошик"))
//                mid++;
//            if (res.contains("лолиту"))
//                win++;
//            if (res.contains("лох"))
//                loh++;
//           i++;
//        }

//        System.out.println("Проигрыш встретился: " + loh + " раз");
//        System.out.println("Выигрыш встретился: " + win + " раз");
//        System.out.println("Ничья встретилась: " + mid + " раз");
    }
}
