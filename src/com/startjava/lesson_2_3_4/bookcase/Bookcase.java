package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    public static final int MAX_BOOKS = 10;
    private int booksCount;
    private Book[] books;

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
            throw new IllegalArgumentException("Ошибка: книга не найдена.");
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
        System.arraycopy(books, index + 1, books, index, books.length - (index + 1));
        books[books.length - 1] = null;
        booksCount--;
    }

    public int getFreeShelvesCount() {
        return books.length - booksCount;
    }

    public void clearAll() {
        books = new Book[books.length];
        booksCount = 0;
    }
}
