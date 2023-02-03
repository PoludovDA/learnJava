package com.company.collectionLearn;

import java.util.Set;
import java.util.TreeSet;

public class Task2 {
    public static void main(String[] args) {
//        TreeSet<HeavyBox> boxes = new TreeSet(new HeavyBox.WeightComparator());
        TreeSet<HeavyBox> boxes = new TreeSet();
        boxes.add(new HeavyBox(24));
        boxes.add(new HeavyBox(23));
        boxes.add(new HeavyBox(53));
        boxes.add(new HeavyBox(12));
        boxes.forEach(HeavyBox::print);
    }
}
