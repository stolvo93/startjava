package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.PublicationYearTooEarlyException;
import java.time.Year;
import java.util.Arrays;

public class Bookcase {
    public static final int CAPACITY = 10;
    public static final Year MIN_PUBLICATION_YEAR = Year.of(1800);
    private static final int INITIAL_CAPACITY = 3;
    private static final double GROWTH_FACTOR = 1.5;
    private final Book[] books;
    private int booksCount;

    public Bookcase() {
        books = new Book[CAPACITY];
    }

    public int getBooksCount() {
        return booksCount;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public boolean add(Book book) {
        validateBookForAdding(book);
        if (booksCount == books.length) {
            return false;
        }

        books[booksCount] = book;
        booksCount++;
        return true;
    }

    private static void validateBookForAdding(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Книга не указана.");
        }
        if (book.getPublicationYear().isBefore(MIN_PUBLICATION_YEAR)) {
            throw new PublicationYearTooEarlyException(String.format(
                    "Недопустимый год публикации (%d). Минимальный год: %d.",
                    book.getPublicationYear().getValue(), MIN_PUBLICATION_YEAR.getValue()));
        }
    }

    public Book[] find(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название искомой книги не указано.");
        }

        Book[] foundBooks = new Book[INITIAL_CAPACITY];
        int foundCount = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                if (foundCount == foundBooks.length) {
                    foundBooks = extendCapacity(foundBooks);
                }
                foundBooks[foundCount] = books[i];
                foundCount++;
            }
        }

        return foundCount == foundBooks.length ? foundBooks : trimToSize(foundBooks, foundCount);
    }

    private static Book[] extendCapacity(Book[] books) {
        return Arrays.copyOf(books, (int) (books.length * GROWTH_FACTOR));
    }

    private static Book[] trimToSize(Book[] books, int size) {
        return Arrays.copyOf(books, size);
    }

    public int remove(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название удаляемой книги не указано.");
        }

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
        booksCount--;
        System.arraycopy(books, index + 1, books, index, booksCount - index);
        books[booksCount] = null;
    }

    public int getFreeShelvesCount() {
        return books.length - booksCount;
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }
}
