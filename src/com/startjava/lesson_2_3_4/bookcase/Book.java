package com.startjava.lesson_2_3_4.bookcase;

import java.time.LocalDate;
import java.util.Arrays;

public class Book {
    private static final int MIN_PUBLICATION_YEAR = 1800;
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
                    "%nОшибка: недопустимый год публикации. Введите значение между %d и %d.",
                    MIN_PUBLICATION_YEAR, LocalDate.now().getYear()));
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

    public Book clone() {
        return new Book(author, title, year);
    }

//    public boolean equals(Book book) {
//        return
//    }

    @Override
    public String toString() {
        String book = String.join(", ", author, title, String.valueOf(year));
        final int maxLineLength = Bookcase.WIDTH - 4;
        if (book.length() > maxLineLength) {
            return splitIntoBorderedLines(book, maxLineLength);
        }
        return makeLineBordered(book);
    }

    public String splitIntoBorderedLines(String string, int maxLineLength) {
        char[][] lines = new char[0][];
        char[] chars = string.toCharArray();
        int lineStart = 0;
        int lineEnd = maxLineLength;
        while (lineEnd < chars.length) {
            lines = addNewLine(lines);
            int lastLine = lines.length - 1;

            boolean hasWhitespace = false;
            for (int i = lineEnd; i > lineStart; i--) {
                if (Character.isWhitespace(chars[i])) {
                    hasWhitespace = true;
                    lines[lastLine] = makeBorderedLine(chars, lineStart, i);
                    lineStart = i + 1;
                    lineEnd = i + 1 + maxLineLength;
                    break;
                }
            }
            if (!hasWhitespace) {
                lines[lastLine] = makeBorderedLine(chars, lineStart, lineEnd);
                lineStart += maxLineLength;
                lineEnd += maxLineLength;
            }
        }
        lines = addNewLine(lines);
        lines[lines.length - 1] = makeBorderedLine(chars, lineStart, chars.length);

        return flattenToString(lines);
    }

    private char[][] addNewLine(char[][] lines) {
        lines = Arrays.copyOf(lines, lines.length + 1);
        lines[lines.length - 1] = new char[lines[0].length];
        return lines;
    }

    private char[] makeBorderedLine(char[] chars, int lineStart, int lineEnd) {
        char[] dest = new char[Bookcase.WIDTH + 1];
        int srcLength = lineEnd - lineStart;
        System.arraycopy(chars, lineStart, dest, 2, srcLength);
        for (int i = (2 + srcLength); i < (dest.length - 2); i++) {
            dest[i] = ' ';
        }
        dest[0] = '|';
        dest[1] = ' ';
        dest[dest.length - 2] = '|';
        dest[dest.length - 1] = '\n';
        return dest;
    }

    private String flattenToString(char[][] chars) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : chars) {
            sb.append(row);
        }
        return sb.toString();
    }

    private String makeLineBordered(String line) {
        char[] borderedLine = makeBorderedLine(line.toCharArray(), 0, line.length());
        return String.valueOf(borderedLine);
    }
}
