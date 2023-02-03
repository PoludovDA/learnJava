package com.company.genericsLearn;

import com.company.collectionLearn.HeavyBox;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinMax <T extends Number> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T getMin() {
        T min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() < min.doubleValue())
                min = array[i];
        }
        return min;
    }

    public T getMax() {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() > max.doubleValue())
                max = array[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Double[] nums = new Double[] {2.5, 4.0, 12.5, 9.6};
        Integer[] nums1 = new Integer[] {3, 5, 9, 6, 46, 39};
        System.out.println(new MinMax<Integer>(nums1).getMax());
        System.out.println(new MinMax<Double>(nums).getMin());
    }
}
