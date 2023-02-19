package com.company.tasks.RandGame;

public class Player {
    private final String name;
    private int money;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void changeMoney(int money) {
        this.money = this.money + money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return name + " счет: " + money;
    }
}
