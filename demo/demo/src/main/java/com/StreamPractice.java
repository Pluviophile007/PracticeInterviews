package com;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        Stream<Integer> streamInt = Stream.iterate(0,(i)->i+1);
        System.out.println(streamInt.limit(100).mapToInt(i->i).sum());

        Stream<Integer> streamGenerate = Stream.generate(()-> {return 100;});
        System.out.println(streamGenerate.limit(100).mapToInt(i->i).sum());
    }
}
