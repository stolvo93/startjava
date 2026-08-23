package com.startjava.lesson_2_3_4.bookcase;

import java.time.LocalDate;

public class Book {
    private static final int MIN_PUBLICATION_YEAR = 1700;
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("\nОшибка: автор книги не указан.");
        }
        this.author = author;

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("\nОшибка: название книги не указано.");
        }
        this.title = title;

        if (year < MIN_PUBLICATION_YEAR || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException(String.format(
                    "%nОшибка: недопустимый год публикации. Год издания должен быть между %d и текущим.",
                    MIN_PUBLICATION_YEAR));
        }
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book copy() {
        return new Book(author, title, year);
    }

    @Override
    public String toString() {
        return String.join(", ", author, title, String.valueOf(year));
    }
}
