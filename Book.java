package be.intecbrussel.opdrachten.fridayopdracht;

import java.time.*;

public class Book {

    private String title;
    private Person author;
    private LocalDate releaseDate;
    private String genre;

    public Book(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "'" + title + '\'' +
                ", author: " + author +
                ", releaseDate: " + releaseDate +
                ", genre: " + genre;
    }
}
