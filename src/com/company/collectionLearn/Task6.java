package com.company.collectionLearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        LinkedList<HeavyBox> boxes = new LinkedList<>();
        boxes.addLast(new HeavyBox(44));
        boxes.addLast(new HeavyBox(24));
        boxes.addLast(new HeavyBox(46));
        boxes.addLast(new HeavyBox(29));
        boxes.addLast(new HeavyBox(32));
        boxes.addLast(new HeavyBox(5));
        boxes.addLast(new HeavyBox(16));

        List<HeavyBox> bigBoxes = new ArrayList<>();
        bigBoxes = boxes.stream().filter(x-> x.getWeight() > 30).collect(Collectors.toList());

        boxes.removeIf(hb -> hb.getWeight() > 30);
        System.out.println(boxes);
        System.out.println(bigBoxes);
    }
}
