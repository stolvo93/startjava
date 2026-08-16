package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    public static final int WIDTH = 80;
    private int booksCount;
    private Book[] books;

    public Bookcase() {
        books = new Book[10];
    }

    public int getBooksCount() {
        return booksCount;
    }

    public Book[] find(String title) {
        Book[] foundBooks = new Book[0];
        for (Book book : books) {
            if (book == null) break;
            if (book.getTitle().equals(title)) {
                foundBooks = Arrays.copyOf(foundBooks, foundBooks.length + 1);
                foundBooks[foundBooks.length - 1] = book.clone();
            }
        }
        return foundBooks;
    }

    public void add(Book book) {
        books[booksCount] = book.clone();
        booksCount++;
        if (booksCount == books.length) exetendSize();
    }

    private void exetendSize() {
        books = Arrays.copyOf(books, (int) (1.5 * books.length));
    }

    public int remove(String title) {
        int booksRemoved = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                remove(i);
                booksRemoved++;
            }
        }
        return booksRemoved;
    }

    public int remove(Book book) {
        int booksRemoved = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].equals(book)) {
                remove(i);
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

    public Book[] getBooks() {
        Book[] booksCopy = new Book[booksCount];
        for (int i = 0; i < booksCount; i++) {
            booksCopy[i] = books[i].clone();
        }
        return booksCopy;
    }

    public int getFreeShelvesNumber() {
        return books.length - booksCount;
    }

    public void clearAll() {
        books = new Book[books.length];
    }
}
