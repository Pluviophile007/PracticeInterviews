package com.mycompany.java8.practice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8FunToMapCollision {
    public static void main(String[] args) {

        try {
            Map<Integer, Book> listBooks =
                    generateBooks().stream().collect(Collectors.toMap(Book::getPublishingYear,
                            Function.identity()));
            System.out.println(listBooks);
        }catch (IllegalStateException ie)
        {
            System.out.println("Kindly use merge funtion.");
        }
        Map<Integer, Book> listBooksWithoutException =
                generateBooks().stream().collect(Collectors.toMap(Book::getPublishingYear,
                        Function.identity(), (old1, new1)->old1, LinkedHashMap::new));
        System.out.println(listBooksWithoutException);

        System.out.println("By java 8 method");
    }

    public static List<Book> generateBooks() {

       return List.of(new Book("MayankTripathi", "Pluviophile", 1991),
               new Book("AnkurTripathi", "Hodophile", 1989),
               new Book("AnkurTripathi", "Hodophile", 1992),
               new Book("ShashankTripathi", "Heliophile", 1991),
               new Book("ShashankTripathi", "Heliophile", 1994),
               new Book("MayankTripathi", "Zenophile",  1989));
    }

    static class Book
    {
        String author;

        String name;

        int publishingYear;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book)) return false;
            Book book = (Book) o;
            return getPublishingYear() == book.getPublishingYear() && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getName(), book.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAuthor(), getName(), getPublishingYear());
        }

        @Override
        public String toString() {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", name='" + name + '\'' +
                    ", publishingYear=" + publishingYear +
                    '}';
        }

        public Book(String author, String name, int publishingYear) {
            this.author = author;
            this.name = name;
            this.publishingYear = publishingYear;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPublishingYear() {
            return publishingYear;
        }

        public void setPublishingYear(int publishingYear) {
            this.publishingYear = publishingYear;
        }
    }
}
