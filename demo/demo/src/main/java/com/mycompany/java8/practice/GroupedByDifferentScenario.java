package com.mycompany.java8.practice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.mycompany.java8.practice.Java8FunToMapCollision.*;

public class GroupedByDifferentScenario {
    public static void main(String[] args) {
        // simple grouped by
        List<Book> books = generateBooks();
        Map<String, List<Book>> byName = books.stream().collect(Collectors.groupingBy(Book::getName));
        System.out.println("By name in default List"+byName);

        Map<String, Set<Book>> byNameInSet = books.stream().collect(
                Collectors.groupingBy(Book::getName, Collectors.toSet()));

        System.out.println("By name in set  "+byNameInSet);


        Map<Object, Set<Book>> byNameInDiffKey = books.stream().collect(
                Collectors.groupingBy((b)->new Key(b.getName()), Collectors.toSet()));

        System.out.println("By name in with Diff Key  "+byNameInDiffKey);

        Map<Key,Map<String, List<Book>>> booksInComplexFormat= books.stream().collect(
                Collectors.groupingBy((b)->new Key(b.getName()), Collectors.groupingBy(Book::getAuthor)));

        System.out.println("By name in By author with Diff Key  "+booksInComplexFormat);

        Map<Key, Double> averagingInt= books.stream().collect(
                Collectors.groupingBy((b)->new Key(b.getName()), Collectors.averagingInt(Book::getPublishingYear)
                                        ));

        System.out.println("By name in By author with Diff Key  "+averagingInt);


        Map<Key, Integer> summingInt= books.stream().collect(
                Collectors.groupingBy((b)->new Key(b.getName()), Collectors.summingInt(Book::getPublishingYear)
                ));

        System.out.println("By Summing int "+summingInt);

        // max and min By
        Map<String, Optional<Book>> maxYear= books.stream().collect(
                Collectors.groupingBy(Book::getAuthor,
                        Collectors.maxBy(Comparator.comparingInt(Book::getPublishingYear))));
        System.out.println("Key vs Max of publish year ");
        System.out.println(maxYear);

        // Summarizing Int and Summarizing Double and etc.

        // max and min By
        Map<String, IntSummaryStatistics> booksSummarizingInt= books.stream().collect(
                Collectors.groupingBy(Book::getAuthor,
                        Collectors.summarizingInt(Book::getPublishingYear)));
        System.out.println("Summarizing int of books");
        System.out.println(booksSummarizingInt);
        /**
         * Collectors. mapping
         * Collectors.summarizingInt
         * Collectors.summarizingDouble
         * Collectors.mapping
         * Collectors.maxBy
         * Collectors.minBy()
         * Collectors.counting()
         *
         */
       Map<String, List<Integer>> mappingExamp = books.stream().collect(
                Collectors.groupingBy(Book::getAuthor,
                        Collectors.mapping(Book::getPublishingYear, Collectors.toList())));

        System.out.println(mappingExamp);

        // Collectors.mapping
        Map<String, String>  output= books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.mapping(Book::getName, Collectors.joining(", ", "Post titles: [", "]"))));
        System.out.println(output);

        // return type modifying

        Map<Integer, List<Book>> postsPerType = books.stream()
                                .collect(Collectors.groupingBy(Book::getPublishingYear,
                        LinkedHashMap::new , Collectors.toList()));

        // Collectors.teeing
        HashMap<String, Book> result = books.stream().collect(
                Collectors.teeing(
                        Collectors.maxBy(Comparator.comparing(Book::getPublishingYear)),
                        Collectors.minBy(Comparator.comparing(Book::getPublishingYear)),
                        (e1, e2) -> {
                            HashMap<String, Book> map = new HashMap();
                            map.put("MAX", e1.get());
                            map.put("MIN", e2.get());
                            return map;
                        }
                ));



    }




    static class Key
    {
        private String name;

        public Key(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return Objects.equals(getName(), key.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }
    }
}
