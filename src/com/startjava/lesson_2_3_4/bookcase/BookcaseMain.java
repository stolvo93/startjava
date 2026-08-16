package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class BookcaseMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookcase bookcase = new Bookcase();
        BookcaseUi.makeIneraction(bookcase, scanner);
//        String author = "Рэй Брэдбери";
//        String title = "451 градус по Фаренгейту";
//        int year = 1980;
//
//        Book book = new Book(author, title, year);
//        System.out.print(book);

    }
}
