package com.company.casino;

import java.util.Arrays;

public class Casino {
    private int maxJackPot;
    private String[] jackPotList;
    private double[] probabilityList;
    private double yourBet;

    public Casino(int maxJackPot, int yourBet) {
        this.maxJackPot = maxJackPot;
        this.jackPotList = new String[] {String.format("Вы выиграли свои %dр, купи себе дошик", yourBet),
                String.format("Вы выиграли %sр, теперь можно снять лолиту", maxJackPot), "Ебать ты лох"};
        this.probabilityList = new double[] {4, 1, 6};
        this.yourBet = yourBet;
    }

    public String getMyJackpot() {
        probabilityList = new double[] {4, 1 + 10 * this.yourBet/ this.maxJackPot, 6};
        double sumProbability = 0;
        for (double i : probabilityList)
            sumProbability += i;
        double result = Math.random() * sumProbability;
        double count = 0;
        for (int i = 0; i < probabilityList.length; i++) {
            if (count <= result && result < probabilityList[i] + count) {
                return jackPotList[i];
            }
            count += probabilityList[i];
        }
        return "Ошибка";
    }

    @Override
    public String toString() {
        return "Casino{" +
                "maxJackPot=" + maxJackPot +
                ", jackPotList=" + Arrays.toString(jackPotList) +
                ", probabilityList=" + Arrays.toString(probabilityList) +
                ", yourBet=" + yourBet +
                '}';
    }
}
