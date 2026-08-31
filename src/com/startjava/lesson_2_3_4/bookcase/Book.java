package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;

public class Book {
    private final String author;
    private final String title;
    private final Year year;

    public Book(String author, String title, Year year) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор книги не указан.");
        }
        this.author = author;

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не указано.");
        }
        this.title = title;

        if (year == null) {
            throw new IllegalArgumentException("Год публикации книги не указан.");
        }
        if (year.isAfter(Year.now())) {
            throw new IllegalArgumentException("Некорректный год издания (" + year.getValue() +
                    "). Год публикации не может превышать текущий год.");
        }
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public Year getYear() {
        return year;
    }

    public Book copy() {
        return new Book(author, title, year);
    }

    @Override
    public String toString() {
        return String.format("%s - \"%s\" (%d)", author, title, year.getValue());
    }
}
