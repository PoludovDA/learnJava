package com.company.collectionLearn;


public class HeavyBox implements Box, Comparable<HeavyBox> {
    private int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public HeavyBox() {
        weight = 0;
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                "weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void print() {
        System.out.println("HeavyBox: " + weight + " кг");
    }

    @Override
    public int compareTo(HeavyBox o) {
        return this.getWeight() - o.getWeight();
    }
}
