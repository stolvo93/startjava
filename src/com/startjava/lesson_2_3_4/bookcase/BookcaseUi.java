package com.startjava.lesson_2_3_4.bookcase;

import java.util.Random;

public class BookcaseUi {
    private static final Random random = new Random();

    public static void printMenu(Bookcase bookcase) {
        if (bookcase.getBooksNumber() == 0) {
            System.out.println("1. " + MenuItem.ADD_BOOK.text());
            System.out.println("2. " + MenuItem.QUIT.text());
        }
        if (bookcase.getBooksNumber() > 0) {
            int itemNumber = 1;
            for (MenuItem item : MenuItem.values()) {
                System.out.println(itemNumber + ". " + item.text());
            }
        }
    }

    public static void printBookcase(Bookcase bookcase) {}

    // public static void typewrite(String text) {
    //     Thread.sleep(1000);
    //     char[] textCharacters = text.toCharArray();
    //     for (char character : textCharacters) {
    //         System.out.print(character);
    //         int pause = random.nextInt(150, 500);
    //         try {
    //             Thread.sleep(pause);
    //         } catch (InterruptedException ignored) {
    //             // Продолжаем работу без задержки
    //         }
    //     }
    //     System.out.println();
    // }
}
