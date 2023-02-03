package com.company.collectionLearn;

public class Toy {
    private int cost;
    private String material;

    public Toy(int cost, String material) {
        this.cost = cost;
        this.material = material;
    }

    public int getCost() {
        return cost;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "cost=" + cost +
                ", material='" + material + '\'' +
                '}';
    }
}
