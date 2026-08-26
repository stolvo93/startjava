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
        if (book == null) {
            throw new IllegalArgumentException("Ошибка: книга не указана.");
        }
        if (book.getYear().isBefore(MIN_PUBLICATION_YEAR)) {
            throw new IllegalArgumentException(String.format("""
                    Ошибка: недопустимый год публикации (%d). Шкаф не принимает книги, изданные \
                    раньше %d года. Попробуйте добавить книгу другого года публикации.
                    """, book.getYear().getValue(), MIN_PUBLICATION_YEAR.getValue()));
        }
        if (booksCount == books.length) {
            return false;
        }

        books[booksCount] = book.copy();
        booksCount++;
        return true;
    }

    public Book[] find(String title) {
        Book[] foundBooks = new Book[0];
        for (Book book : books) {
            if (book == null)
                break;
            if (book.getTitle().equals(title)) {
                foundBooks = Arrays.copyOf(foundBooks, foundBooks.length + 1);
                foundBooks[foundBooks.length - 1] = book.copy();
            }
        }
        return foundBooks;
    }

    public int remove(String title) {
        int booksRemoved = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                remove(i--);
                booksRemoved++;
            }
        }
        return booksRemoved;
    }

    private void remove(int index) {
        System.arraycopy(books, index + 1, books, index, booksCount - (index + 1));
        books[booksCount - 1] = null;
        booksCount--;
    }

    public int getFreeShelvesCount() {
        return books.length - booksCount;
    }

    public void clearAll() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }
}
