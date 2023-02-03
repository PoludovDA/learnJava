package com.company.collectionLearn;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task4 {
    public static void main(String[] args) {
        Set set1 = new LinkedHashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(7);

        Set set2 = new LinkedHashSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(7);

        Set set3 = new LinkedHashSet();
        set3.add(5);
        set3.add(6);
        set3.add(7);

        System.out.println(union(set1, set2));
        System.out.println(union(set1, set2, set3));

        Set<String> intersection = new LinkedHashSet<>(set1); // use the copy constructor
        intersection.retainAll(set2);
        System.out.println(intersection);

        System.out.println(intersect(set1, set2, set3));
    }

    private static Set union(Set<?>... set) {
        Set result = new LinkedHashSet();
        for (Set<?> s : set) {
            result.addAll(s);
        }
        return result;
    }

    private static Set<Integer> intersect(Set<Integer>... set) {
        LinkedHashSet result = new LinkedHashSet(set[0]);
        int setNumber = 1;
        while (setNumber < set.length) {
            result.retainAll(set[setNumber]);
            setNumber++;
        }
        return result;
    }
}
