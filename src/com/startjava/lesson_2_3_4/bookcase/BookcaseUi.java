package com.startjava.lesson_2_3_4.bookcase;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BookcaseUi {
    private static final MenuItem[] shortMenu = { MenuItem.ADD_BOOK, MenuItem.QUIT };
    private static final MenuItem[] fullMenu = MenuItem.values();
    private static final Random random = new Random();
    private final Scanner scanner;
    private Bookcase bookcase;
    private MenuItem[] currentMenu;

    public BookcaseUi(Scanner scanner, Bookcase bookcase) {
        this.scanner = scanner;
        this.bookcase = bookcase;
    }

    public void makeInteraction() {
        if (bookcase == null) {
            throw new IllegalArgumentException("Ошибка в данных: книжный шкаф не найден.");
        }
        printGreeting();
        printEmptyBookcaseMessage();
        MenuItem choice;
        do {
            printCurrentMenu();
            choice = promptChoice();
            printChoiceMessage(choice);
            executeMenuItem(choice);
            waitForPressingEnter();
        } while (choice != MenuItem.QUIT);
    }

    private static void printGreeting() {
        typewrite("\nДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!\n");
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

    private void printCurrentMenu() {
        updateMenu();

        System.out.println("\nМеню:");
        int itemNumber = 1;
        for (MenuItem item : currentMenu) {
            System.out.println(itemNumber + ". " + item.text());
            itemNumber++;
        }
        System.out.println();
    }

    private void updateMenu() {
        currentMenu = bookcase.getBooksCount() == 0 ? shortMenu : fullMenu;
    }

    private MenuItem promptChoice() {
        int choice = readNumber("Введите номер выбранного пункта меню: ");
        scanner.nextLine();
        try {
            return currentMenu[choice - 1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    "\nОшибка: пункт под номером " + choice + " не представлен в меню. Попробуйте снова.");
            return promptChoice();
        }
    }

    private int readNumber(String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("\nОшибка: введено не целое число.");
            return readNumber("Введите целое число: ");
        }
    }

    private static void printChoiceMessage(MenuItem choice) {
        System.out.println("Выбран пункт \"" + choice.text() + "\".\n");
    }

    private void executeMenuItem(MenuItem choice) {
        switch (choice) {
            case SHOW_BOOKS -> print(bookcase.getBooks(), "КНИЖНЫЙ ШКАФ:");
            case ADD_BOOK -> addBook();
            case FIND_BOOK -> findBook();
            case REMOVE_BOOK -> removeBook();
            case CLEAR_BOOKCASE -> clear();
            case QUIT -> {
            }
        }
    }

    private void print(Book[] books, String header) {
        printBooksAndFreeShelvesCountMessage();

        int indent = (Bookcase.WIDTH - header.length()) / 2;
        System.out.println("\n" + " ".repeat(indent) + header);
        printSeparator();
        for (Book book : books) {
            System.out.print(book);
            printSeparator();
        }
    }

    private void printBooksAndFreeShelvesCountMessage() {
        System.out.printf("В шкафу книг - %d, свободно полок - %d%n",
                bookcase.getBooksCount(), bookcase.getFreeShelvesNumber());
    }

    private static void printSeparator() {
        System.out.println("+" + "-".repeat(Bookcase.WIDTH - 2) + "+");
    }

    private void addBook() {
        Book book = askForBook();
        bookcase.add(book);
        System.out.println("\nКнига добавлена в шкаф.");
        printBooksAndFreeShelvesCountMessage();
    }

    private Book askForBook() {
        String author = readLine("Введите автора книги: ");
        String title = readLine("Введите название книги: ");
        int year = readNumber("Введите год публикации: ");
        scanner.nextLine();
        try {
            return new Book(author, title, year);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Попробуйте снова.\n");
            return askForBook();
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private void findBook() {
        String title = readLine("Введите название книги: ");
        Book[] foundBooks = bookcase.find(title);
        if (foundBooks.length == 0) {
            System.out.println("Поиск по названию книги \"" + title + "\" не дал результата.");
            printBooksAndFreeShelvesCountMessage();
            return;
        }
        print(foundBooks, "КНИГИ, ИМЕЮЩИЕ НАЗВАНИЕ \"" + title + "\":");
    }

    private void removeBook() {
        String title = readLine("Введите название книги, которую хотите удалить: ");
        int booksRemoved = bookcase.remove(title);
        System.out.println("Удалено книг: " + booksRemoved);
        printBooksAndFreeShelvesCountMessage();
    }

    private void clear() {
        bookcase.clearAll();
        System.out.println("Шкаф очищен.");
        printBooksAndFreeShelvesCountMessage();
    }

    private void waitForPressingEnter() {
        readLine("\nДля продолжения работы нажмите клавишу <Enter> ");
    }
}
