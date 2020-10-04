package be.intecbrussel.opdrachten.fridayopdracht;

import java.time.*;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookApp {

    public static void main(String[] args) {
        Book[] bookArray = new Book[5];
        Person p1 = new Person("Kevin", "Grevioux", LocalDate.of(1962, 9, 9));
        bookArray[0] = new Book("Harry Potter and the Deathly Hallows", new Person("J.K",
                        "Rowling", LocalDate.of(1965, 7, 3)), LocalDate
                        .of(2020, 8, 8), "fantasy");
        bookArray[1] = new Book("One Piece", new Person("Eiichiro", "Oda", LocalDate
                        .of(1975, 1, 1)), LocalDate.of(1997, 7, 2)
                        , "shonen");
        bookArray[2] = new Book("Gangsta", new Person("Koshke", "Kosuke", LocalDate
                        .of(1974, 5, 5)), LocalDate.of(2014, 8, 27)
                        ,"seinen");
        bookArray[3] = new Book("Blue Marvel", p1, LocalDate.of(2008, 11, 1)
                        , "super hero");
        bookArray[4] = new Book("Icon", p1, LocalDate.of(1993, 5, 1)
                        , "super hero");

        System.out.println(getNewestBook(bookArray));
        printYoungestAuthor(bookArray);
        System.out.println();
        printSortedByTitle(bookArray);
        System.out.println();
        countBooksPerAuthor(bookArray);
    }

    public static Book getNewestBook(Book[] books){

        return Stream.of(books)
                .sorted(Comparator.comparing(Book::getReleaseDate).reversed())
                .findFirst()
                .get();
    }

    public static void printYoungestAuthor(Book[] books) {

        Person youngest = Stream.of(books)
                .map(e -> e.getAuthor())
                .distinct()
                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
                .findFirst()
                .get();

        System.out.println();
        System.out.println(youngest);
    }

    public static void printSortedByTitle(Book[] books) {

        Stream.of(books)
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public static void countBooksPerAuthor(Book[] books) {

        Set<Person> authors = Stream.of(books)
                .map(Book::getAuthor)
                .collect(Collectors.toSet());

        authors.forEach(e -> System.out.println("Author: " + e.getFirstName() + " " + e
                .getLastName() + " - Books: " + Stream.of(books).filter(b -> b.getAuthor().equals(e)).count()));
    }
}
