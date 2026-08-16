package com.startjava.lesson_2_3_4.bookcase;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BookcaseUi {
    private static final Random random = new Random();
    private static final MenuItem[] SHORT_MENU = {MenuItem.ADD_BOOK, MenuItem.QUIT};
    private static final MenuItem[] FULL_MENU = MenuItem.values();
    private static MenuItem[] currentMenu;

    public static void makeIneraction(Bookcase bookcase, Scanner scanner) {
        if (bookcase == null) {
            throw new IllegalArgumentException("Ошибка в данных: книжный шкаф не найден.");
        }
        printGreeting();
        printEmptyBookcaseMessage();
        MenuItem choice;
        do {
            printCurrentMenu(bookcase);
            choice = promptChoice(scanner);
            executeMenuItem(bookcase, choice, scanner);
        } while (choice != MenuItem.QUIT);
    }

    private static void printGreeting() {
        typewrite("ДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!\n");
    }

    private static void typewrite(String text) {
        char[] textCharacters = text.toCharArray();
        for (char character : textCharacters) {
            System.out.print(character);
            int pause = random.nextInt(150, 250);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException ignored) {
                // Продолжаем работу без задержки
            }
        }
        System.out.println();
    }

    private static void printEmptyBookcaseMessage() {
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
    }

    private static void printCurrentMenu(Bookcase bookcase) {
        updateMenu(bookcase);

        System.out.println("\nМеню:");
        int itemNumber = 1;
        for (MenuItem item : currentMenu) {
            System.out.println(itemNumber + ". " + item.text());
            itemNumber++;
        }
        System.out.println();
    }

    private static void updateMenu(Bookcase bookcase) {
        currentMenu = bookcase.getBooksCount() == 0 ? SHORT_MENU : FULL_MENU;
    }

    private static MenuItem promptChoice(Scanner scanner) {
        int choice = readNumber(scanner, "Введите номер выбранного пункта меню: ");
        scanner.nextLine();
        try {
            return currentMenu[choice - 1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    "\nОшибка: пункт под номером " + choice + " не представлен в меню. Попробуйте снова.");
            return promptChoice(scanner);
        }
    }

    private static int readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("\nОшибка: введено не целое число.");
            return readNumber(scanner, "Введите целое число: ");
        }
    }

    private static void executeMenuItem(Bookcase bookcase, MenuItem choice, Scanner scanner) {
        switch (choice) {
            case SHOW_BOOKS -> print(bookcase.getBooks(), "КНИЖНЫЙ ШКАФ:");
            case ADD_BOOK -> addBook(bookcase, scanner);
            case FIND_BOOK -> findBook(bookcase, scanner);
            case REMOVE_BOOK -> removeBook(bookcase);
            case CLEAR_BOOKCASE -> clear(bookcase);
            case QUIT -> {
            }
        }
    }

    private static void print(Book[] books, String header) {
        int indent = (Bookcase.WIDTH - header.length()) / 2;
        System.out.println("\n" + " ".repeat(indent) + header);
        printSeparator();
        for (Book book : books) {
            System.out.print(book);
            printSeparator();
        }
    }

    private static void printSeparator() {
        System.out.println("+" + "-".repeat(Bookcase.WIDTH - 2) + "+");
    }

    private static void addBook(Bookcase bookcase, Scanner scanner) {
        Book book = askForBook(scanner);
        bookcase.add(book);
    }

    private static Book askForBook(Scanner scanner) {
        String author = readLine(scanner, "Введите автора книги: ");
        String title = readLine(scanner, "Введите название книги: ");
        int year = readNumber(scanner, "Введите год публикации: ");
        scanner.nextLine();
        try {
            return new Book(author, title, year);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Попробуйте снова.");
            return askForBook(scanner);
        }
    }

    private static String readLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void findBook(Bookcase bookcase, Scanner scanner) {
        String title = readLine(scanner, "Введите название книги: ");
        Book[] foundBooks = bookcase.find(title);
        if (foundBooks.length == 0) {
            System.out.println("Поиск по названию книги \"" + title + "\" не дал результата.");
        }
        print(foundBooks, "КНИГИ, ИМЕЮЩИЕ НАЗВАНИЕ \"" + title + "\":");
    }

    private static void removeBook(Bookcase bookcase) {
    }


    private static void clear(Bookcase bookcase) {
    }
}
