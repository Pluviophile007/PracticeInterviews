package com.practice.value;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortByValueInMap {
    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        map.put("Mayank", 1041);
        map.put("Shashank", 1081);
        map.put("Tripathi", 1011);
        map.put("ZooPracticioner", 1012);

        System.out.println(" Soritng by Key of map ");
        Map<String, Integer> linkedMapByValueSorted =
         map.entrySet().stream().sorted(Comparator.comparing(Entry::getKey))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (old, N )-> old  ,LinkedHashMap::new));

        System.out.println(linkedMapByValueSorted);

        System.out.println(" Soritng by Value of map ");
        Map<String, Integer> linkedMapSortedByValue = map.entrySet().stream().sorted(Comparator.comparing(Entry::getValue)).collect(Collectors.toMap(Entry::getKey,
                Entry::getValue, (old,N)->old, LinkedHashMap::new));


        System.out.println(linkedMapSortedByValue);

        System.out.println(" Soritng by Value of map Java 8 fn ");

        Map<String, Integer> linkedMapSortedByValueJava8 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey,
                Entry::getValue, (old,N)->old, LinkedHashMap::new));

        System.out.println(linkedMapSortedByValueJava8);





    }

}
