package com.jozsef.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionProblems {
    private static void concurrentModificationException() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("Maaike", "Java");
        stringStringMap.put("Remsey", "C#");

        for (String k : stringStringMap.keySet()) {
            System.out.println(k + " loves coding " + stringStringMap.get(k));
            stringStringMap.remove(k);
        }
    }

    private static void concurrentModification() {
        Map<String, String> stringStringMap = new ConcurrentHashMap<>();
        stringStringMap.put("Maaike", "Java");
        stringStringMap.put("Remsey", "C#");

        for (String k : stringStringMap.keySet()) {
            System.out.println(k + " loves coding " + stringStringMap.get(k));
            stringStringMap.remove(k);
        }
    }

    public static void main(String[] args) {
//        concurrentModificationException();
        concurrentModification();
    }
}
