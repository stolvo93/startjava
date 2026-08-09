package com.startjava.lesson_2_3_4.bookcase;

import java.time.LocalDate;

public class Book {
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        if (author == null) {

        }
        this.author = author;
        if (title == null) {

        }
        this.title = title;
        if (year < 1800 && year > LocalDate.now().getYear()) {

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
        String string = String.join(", ", author, title, String.valueOf(year));
        if (string.length() > 80) {
            char[] chars = string.toCharArray();
            for (int i = 80; i > 0; i++) {
                if (Character.isWhitespace(chars[i])) {
                    chars[i] = '\n';
                    string = String.valueOf(chars);
                    break;
                }
            }
        }
        return string;
    }
}
