package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BookcaseUi {
    private static final int MIN_TYPEWRITER_DELAY_MS = 100;
    private static final int MAX_TYPEWRITER_DELAY_MS = 200;
    private static final int WIDTH = 80;
    private static final MenuItem[] emptyBookcaseMenu = { MenuItem.ADD_BOOK, MenuItem.QUIT };
    private static final MenuItem[] filledBookcaseMenu = {
            MenuItem.FIND_BOOK, MenuItem.REMOVE_BOOK,
            MenuItem.CLEAR_BOOKCASE, MenuItem.QUIT
    };
    private static final MenuItem[] fullMenu = MenuItem.values();
    private final Random random = new Random();
    private final Scanner scanner;
    private final Bookcase bookcase;

    public BookcaseUi(Scanner scanner, Bookcase bookcase) {
        if (scanner == null) {
            throw new IllegalArgumentException("Сканер не указан.");
        }
        if (bookcase == null) {
            throw new IllegalArgumentException("Книжный шкаф не указан.");
        }
        this.scanner = scanner;
        this.bookcase = bookcase;
    }

    public void run() {
        printGreeting();
        MenuItem choice;
        while (true) {
            printBookcase();
            MenuItem[] currentMenu = getCurrentMenu();
            printMenu(currentMenu);
            choice = promptChoice(currentMenu);
            printChoiceMessage(choice);
            executeSelectedMenuItem(choice);
            if (choice == MenuItem.QUIT) {
                break;
            }
            printBookcaseStats();
            waitForEnter();
        }
    }

    private void printGreeting() {
        typewrite("\nДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!\n");
    }

    private void typewrite(String text) {
        char[] textCharacters = text.toCharArray();
        for (char character : textCharacters) {
            System.out.print(character);
            int pause = random.nextInt(MIN_TYPEWRITER_DELAY_MS, MAX_TYPEWRITER_DELAY_MS);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException ignored) {
                // Продолжаем работу без задержки
            }
        }
        System.out.println();
    }

    private void printBookcase() {
        if (bookcase.getBooksCount() == 0) {
            printEmptyBookcaseMessage();
            return;
        }
        printBooksAsBookcase(bookcase.getBooks(), "КНИЖНЫЙ ШКАФ:");
    }

    private void printBooksAsBookcase(Book[] books, String header) {
        int indent = Math.max(0, (WIDTH - header.length()) / 2);
        System.out.println("\n" + " ".repeat(indent) + header);
        printSeparator();
        for (Book book : books) {
            printBookOnShelf(book);
            printSeparator();
        }
    }

    private static void printEmptyBookcaseMessage() {
        System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу.");
    }

    private static void printSeparator() {
        System.out.println("+" + "-".repeat(WIDTH - 2) + "+");
    }

    private void printBookOnShelf(Book book) {
        String bookString = book.toString();
        int maxLineLength = BookcaseUi.WIDTH - 4;
        if (bookString.length() > maxLineLength) {
            System.out.print(formatMultilineShelf(bookString, maxLineLength));
            return;
        }
        System.out.print(wrapLineWithBorder(bookString));
    }

    private static String formatMultilineShelf(String shelfContent, int maxLineLength) {
        StringBuilder result = new StringBuilder();

        int lineStart = 0;
        while (lineStart + maxLineLength < shelfContent.length()) {
            int lineEnd = lineStart + maxLineLength;
            int breakIndex = lineEnd;

            while (breakIndex > lineStart && !isWhitespace(shelfContent, breakIndex)) {
                breakIndex--;
            }

            if (breakIndex == lineStart) {
                breakIndex = lineEnd;
            }

            result.append(createBorderedLine(shelfContent, lineStart, breakIndex));

            lineStart = breakIndex;
            if (isWhitespace(shelfContent, lineStart) && lineStart < shelfContent.length()) {
                lineStart++;
            }
        }
        result.append(createBorderedLine(shelfContent, lineStart, shelfContent.length()));
        return result.toString();
    }

    private static boolean isWhitespace(String string, int index) {
        return Character.isWhitespace(string.charAt(index));
    }

    private static char[] createBorderedLine(String string, int lineStart, int lineEnd) {
        char[] src = string.toCharArray();
        char[] dest = new char[BookcaseUi.WIDTH + 1];
        int lineLength = lineEnd - lineStart;
        System.arraycopy(src, lineStart, dest, 2, lineLength);
        for (int i = (2 + lineLength); i < (dest.length - 2); i++) {
            dest[i] = ' ';
        }
        dest[0] = '|';
        dest[1] = ' ';
        dest[dest.length - 2] = '|';
        dest[dest.length - 1] = '\n';
        return dest;
    }

    private static String wrapLineWithBorder(String line) {
        char[] borderedLine = createBorderedLine(line, 0, line.length());
        return String.valueOf(borderedLine);
    }

    private void printMenu(MenuItem[] menu) {
        System.out.println("\nМеню:");
        int itemNumber = 1;
        for (MenuItem item : menu) {
            System.out.println(itemNumber + ". " + item.text());
            itemNumber++;
        }
        System.out.println();
    }

    private MenuItem[] getCurrentMenu() {
        int booksCount = bookcase.getBooksCount();
        MenuItem[] currentMenu = booksCount == 0 ? emptyBookcaseMenu
                : booksCount == Bookcase.MAX_BOOKS ? filledBookcaseMenu : fullMenu;
        return currentMenu;
    }

    private MenuItem promptChoice(MenuItem[] menu) {
        int choice = readInt("Введите номер выбранного пункта меню: ");
        if (choice < 1 || choice > menu.length) {
            System.out.println(
                    "\nОшибка: пункт под номером " + choice + " не представлен в меню. Попробуйте снова.");
            return promptChoice(menu);
        }
        return menu[choice - 1];
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        try {
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;

        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nОшибка: введено не целое число.");
            return readInt("Введите целое число: ");
        }
    }

    private static void printChoiceMessage(MenuItem choice) {
        System.out.println("Выбран пункт \"" + choice.text() + "\".\n");
    }

    private void executeSelectedMenuItem(MenuItem choice) {
        switch (choice) {
            case ADD_BOOK -> addBook();
            case FIND_BOOK -> findBook();
            case REMOVE_BOOK -> removeBook();
            case CLEAR_BOOKCASE -> clearBookcase();
            case QUIT -> {
            }
        }
    }

    private void printBookcaseStats() {
        System.out.printf("В шкафу книг - %d, свободно полок - %d.%n",
                bookcase.getBooksCount(), bookcase.getFreeShelvesCount());
    }

    private void addBook() {
        printPublicationYearLimitWarning();
        Book book = promptBookData();
        try {
            boolean isSuccess = bookcase.add(book);
            printAddBookResult(isSuccess);
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage() +
                    " Попробуйте добавить книгу другого года публикации.\n");
            addBook();
        }
    }

    private static void printPublicationYearLimitWarning() {
        System.out.printf("%nВнимание! Шкаф принимает книги, опубликованные не ранее %d года.%n",
                Bookcase.MIN_PUBLICATION_YEAR.getValue());
    }

    private Book promptBookData() {
        String author = readCleanedNonBlankLine("Введите автора книги: ");
        String title = readCleanedNonBlankLine("Введите название книги: ");
        Year year = readValidPublicationYear("Введите год публикации: ");
        try {
            return new Book(author, title, year);
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage());
            return promptBookData();
        }
    }

    private String readCleanedNonBlankLine(String prompt) {
        System.out.print(prompt);
        while (true) {
            String line = scanner.nextLine().trim();
            if (!line.isBlank()) {
                return line.replaceAll("\\s+", " ");
            }
            System.out.print("Ошибка: введена пустая строка. Попробуйте снова: ");
        }
    }

    private Year readValidPublicationYear(String prompt) {
        Year year;
        while (true) {
            year = Year.of(readInt(prompt));
            if (!year.isAfter(Year.now())) {
                return year;
            }
            printUnacceptableYearError();
        }
    }

    private static void printUnacceptableYearError() {
        System.out.println("\nОшибка: год публикации не может быть больше текущего.");
    }

    private static void printAddBookResult(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("\nКнига добавлена в шкаф.");
        } else {
            System.out.println("\nОшибка: невозможно добавить книгу, так как шкаф заполнен.");
        }
    }

    private void findBook() {
        String title = readCleanedNonBlankLine("Введите название книги: ");
        Book[] foundBooks = bookcase.find(title);
        if (foundBooks.length == 0) {
            System.out.println("\nПоиск по названию книги \"" + title + "\" не дал результата.");
            return;
        }
        printBooksAsBookcase(foundBooks, "КНИГИ, ИМЕЮЩИЕ НАЗВАНИЕ \"" + title + "\":");
    }

    private void removeBook() {
        String title = readCleanedNonBlankLine("Введите название книги, которую хотите удалить: ");
        int booksRemoved = bookcase.remove(title);
        System.out.println("Удалено книг: " + booksRemoved);
    }

    private void clearBookcase() {
        bookcase.clear();
        System.out.println("Шкаф очищен.");
    }

    private void waitForEnter() {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter> ");
        scanner.nextLine();
    }
}
