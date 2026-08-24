package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;

public class Book {
    private String author;
    private String title;
    private Year year;

    public Book(String author, String title, Year year) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("\nОшибка: автор книги не указан.");
        }
        this.author = author;

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("\nОшибка: название книги не указано.");
        }
        this.title = title;
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
        return String.format("%s - \"%s\" (%d)", author, title, year);
    }
}
