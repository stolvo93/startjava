package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    private int booksNumber = 0;
    private Book[] books = new Book[10];

    public int getBooksNumber() {
        return booksNumber;
    }

    public Book[] find(String authorOrTitle) {
        int booksCount = 0;
        for (Book book : books) {
            if (authorOrTitle.equals(book.getAuthor()) || authorOrTitle.equals(book.getTitle())) booksCount++;
        }
        Book[] foundBooks = new Book[booksCount];
        int i = 0;
        for (Book book : books) {
            if (authorOrTitle.equals(book.getAuthor()) || authorOrTitle.equals(book.getTitle())) {
                foundBooks[i++] = book;
            }
        }
        return foundBooks;
    }

//    public Book[] find(String title) {
//        int booksCount = 0;
//        for (Book book : books) {
//        }
//        Book[] foundBooks = new Book[booksCount];
//        int i = 0;
//        for (Book book : books) {
//            if (title.equals(book.getTitle())) {
//                foundBooks[i++] = book;
//            }
//        }
//        return foundBooks;
//    }

    public Book[] find(int year) {
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

    public void add(Book book) {
        books[booksNumber] = book.clone();
        booksNumber++;
        if (booksNumber == books.length) {
            books = Arrays.copyOf(books, (int) (1.5 * books.length));
        }
    }

    public void remove(String title) {
        int booksCount = 0;
        for (int i = 0; i < books.length; i++) {
            if (title.equals(books[i].getTitle())) {
                remove(i);
                booksCount++;
            }
        }
    }

    public void remove(Book book) {
        int booksCount = 0;
        for (int i = 0; i < books.length; i++) {
            if (book.equals(books[i])) {
                remove(i);
                booksCount++;
            }
        }
    }

    private void remove(int index) {
        System.arraycopy(books, index + 1, books, index, books.length - index);
        books[books.length - 1] = null;
        booksNumber--;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getFreeShelvesNumber() {
        return books.length - booksNumber;
    }

    public void clearAll() {
        books = new Book[books.length];
    }
}
