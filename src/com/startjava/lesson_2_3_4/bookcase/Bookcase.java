package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Arrays;

public class Bookcase {
    public static final int MAX_BOOKS = 10;
    public static final Year MIN_PUBLICATION_YEAR = Year.of(1800);
    private final Book[] books;
    private int booksCount;

    public Bookcase() {
        books = new Book[MAX_BOOKS];
    }

    public int getBooksCount() {
        return booksCount;
    }

    public Book[] getBooks() {
        Book[] booksCopy = new Book[booksCount];
        for (int i = 0; i < booksCount; i++) {
            booksCopy[i] = books[i].copy();
        }
        return booksCopy;
    }

    public boolean add(Book book) {
        validateBookForAdding(book);
        if (booksCount == books.length) {
            return false;
        }

        books[booksCount] = book.copy();
        booksCount++;
        return true;
    }

    private void validateBookForAdding(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Книга не указана.");
        }
        if (book.getYear().isBefore(MIN_PUBLICATION_YEAR)) {
            throw new IllegalArgumentException(String.format("""
                    Недопустимый год публикации (%d). Шкаф не принимает книги, изданные \
                    раньше %d года.""",
                    book.getYear().getValue(), MIN_PUBLICATION_YEAR.getValue()));
        }
    }

    public Book[] find(String title) {
        Book[] foundBooks = new Book[0];
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                foundBooks = Arrays.copyOf(foundBooks, foundBooks.length + 1);
                foundBooks[foundBooks.length - 1] = books[i].copy();
            }
        }
        return foundBooks;
    }

    public int remove(String title) {
        int booksRemoved = 0;
        int i = 0;
        while (i < booksCount) {
            if (books[i].getTitle().equals(title)) {
                removeAt(i);
                booksRemoved++;
            } else {
                i++;
            }
        }
        return booksRemoved;
    }

    private void removeAt(int index) {
        System.arraycopy(books, index + 1, books, index, booksCount - (index + 1));
        books[booksCount - 1] = null;
        booksCount--;
    }

    public int getFreeShelvesCount() {
        return books.length - booksCount;
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }
}
