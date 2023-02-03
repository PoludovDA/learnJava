package com.company.collectionLearn;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Стек - одностороняя очередь (с конца)
 * Дек - двустороняя очередь. Та же реализация у LinkedList
 */
public class Task5 {
    public static void main(String[] args) {
        //Реализация со Stack
        Stack stack = new Stack();
        stack.push(new HeavyBox(24));
        stack.push(new HeavyBox(42));
        stack.push(new HeavyBox(8));
        stack.push(new HeavyBox(2));
        System.out.println("Размер стека: " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Размер стека после выпуливания: " + stack.size());

        //Реализация с ArrayDeque
        ArrayDeque<HeavyBox> boxes = new ArrayDeque<>();
        boxes.offerFirst(new HeavyBox(12));
        boxes.offerLast(new HeavyBox(14));
        boxes.addFirst(new HeavyBox(8));
        boxes.addLast(new HeavyBox(10));
        System.out.println("Очередь : " + boxes);

        System.out.println("Удален элемент: " + boxes.pollLast());
        System.out.println("Удален элемент: " + boxes.pollFirst());
        System.out.println("Очередь после удаления: " + boxes);
    }
}
