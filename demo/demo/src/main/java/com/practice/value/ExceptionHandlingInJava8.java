package com.practice.value;

import java.util.List;
import java.util.function.Consumer;

public class ExceptionHandlingInJava8 {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 0);
        integerList.stream().forEach(
                executeWrapper( i-> divideBy10(i) , ArithmeticException.class));

    }

    private static void divideBy10(Integer i) {
         int x = i.intValue() / 0;
    }

    static  <T extends Integer, E extends Exception> Consumer<T> executeWrapper(ThrowableConsumer<T, E> thorowableConsumer
    , Class<E> clazz)
    {
        return i->{
            try {
                thorowableConsumer.accept(i);
            }
            catch (Exception e)
            {
                Exception e1  = clazz.cast(e);
                System.out.println("Can not divide by zero");
                throw new RuntimeException(e1);
            }
        };
    }

    interface ThrowableConsumer<T, E extends Exception>
    {
        void accept(T t) throws E;
    }
}
