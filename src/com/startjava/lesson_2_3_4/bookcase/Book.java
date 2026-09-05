package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;

public final class Book {
    private final String author;
    private final String title;
    private final Year publicationYear;

    public Book(String author, String title, Year publicationYear) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор книги не указан.");
        }
        this.author = author;

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не указано.");
        }
        this.title = title;

        if (publicationYear == null) {
            throw new IllegalArgumentException("Год публикации книги не указан.");
        }
        if (publicationYear.isAfter(Year.now())) {
            throw new IllegalArgumentException("Некорректный год издания (" + publicationYear.getValue() +
                    "). Год публикации не может превышать текущий год.");
        }
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return String.format("%s - \"%s\" (%d)", author, title, publicationYear.getValue());
    }
}
