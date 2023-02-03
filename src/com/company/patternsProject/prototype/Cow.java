package com.company.patternsProject.prototype;

public class Cow implements Clonner{
    private String name;
    private int weight;
    private int id;

    public Cow(String name, int weight, int id) {
        this.name = name;
        this.weight = weight;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", id=" + id +
                '}';
    }

    @Override
    public Object copy() {
        return new Cow(name, weight, id);
    }
}
