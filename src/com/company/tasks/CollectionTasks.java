package com.company.tasks;

import java.util.*;

public class CollectionTasks {
    public static void main(String[] args) {
        HashMap<String, Integer> strList = new HashMap<>();
        strList.put("Мария", 57);
        strList.put("Денис", 82);
        strList.put("Никита", 108);
        strList.put("Санек", 94);

        Set<String> names = strList.keySet();
        Collection<Integer> weights = strList.values();
        System.out.println(strList);

        Iterator iterator = strList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.print(me.getKey() + " : ");
            System.out.println(me.getValue());
        }
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zb");
        treeSet.add("ab");
        treeSet.add("fb");
        treeSet.add("cb");
        System.out.println(treeSet);

    }
}
