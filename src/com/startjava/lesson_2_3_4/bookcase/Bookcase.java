package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    private int booksNumber = 0;
    private Book[] books = new Book[10];

    public Book[] getBooksByAuthor(String author) {
        int booksCount = 0;
        for (Book book : books) {
            if (author.equals(book.getAuthor())) booksCount++;
        }
        Book[] foundBooks = new Book[booksCount];
        int i = 0;
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                foundBooks[i++] = book;
            }
        }
        return foundBooks;
    }

    public Book[] getBooksByTitle(String title) {
        int booksCount = 0;
        for (Book book : books) {
            if (title.equals(book.getTitle())) booksCount++;
        }
        Book[] foundBooks = new Book[booksCount];
        int i = 0;
        for (Book book : books) {
            if (title.equals(book.getTitle())) {
                foundBooks[i++] = book;
            }
        }
        return foundBooks;
    }

    public Book[] getBooksByYear(int year) {
        int booksCount = 0;
        for (Book book : books) {
            if (year == book.getYear()) booksCount++;
        }
        Book[] foundBooks = new Book[booksCount];
        int i = 0;
        for (Book book : books) {
            if (year == book.getYear()) {
                foundBooks[i++] = book;
            }
        }
        return foundBooks;
    }

    public void addBook(Book book) {
        books[booksNumber] = book.clone();
        booksNumber++;
        if (booksNumber == books.length) {
            books = Arrays.copyOf(books, (int) (1.5 * books.length));
        }
    }

    public void removeBooks(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (book.equals(books[i])) {
                removeBook(i);
            }
        }
    }

    public void removeBook(int index) {
        System.arraycopy(books, index + 1, books, index, books.length - index);
        books[books.length - 1] = null;
        booksNumber--;
    }

    private int getBooksNumber() {
        return booksNumber;
    }

    private Book[] getBooks() {
        return books;
    }

    private int getFreeShelvesNumber() {
        return books.length - booksNumber;
    }

    private void clearBookcase() {
        books = new Book[books.length];
    }
}
