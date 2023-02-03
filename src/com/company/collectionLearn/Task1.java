package com.company.collectionLearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<HeavyBox> boxes = new ArrayList<>();
        boxes.add(new HeavyBox(24));
        boxes.add(new HeavyBox(23));
        boxes.add(new HeavyBox(53));
        boxes.add(new HeavyBox(12));

        boxes.forEach(HeavyBox::print);

        System.out.println("После изменения первого ящика и сортировки: ");
        boxes.get(0).setWeight(27);

//        Collections.sort(boxes, new HeavyBox.WeightComparator());

        Iterator iterator = boxes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        boxes.remove(boxes.size() - 1);
    }
}
