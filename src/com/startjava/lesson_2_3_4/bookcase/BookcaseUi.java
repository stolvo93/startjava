package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BookcaseUi {
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
    private MenuItem[] currentMenu;

    public BookcaseUi(Scanner scanner, Bookcase bookcase) {
        if (scanner == null) {
            throw new IllegalArgumentException("Ошибка в данных: сканер не найден.");
        }
        if (bookcase == null) {
            throw new IllegalArgumentException("Ошибка в данных: книжный шкаф не найден.");
        }
        this.scanner = scanner;
        this.bookcase = bookcase;
    }

    public void makeInteraction() {
        printGreeting();
        MenuItem choice;
        while (true) {
            printAsBookcase(bookcase.getBooks(), "КНИЖНЫЙ ШКАФ:");
            printCurrentMenu();
            choice = promptChoice();
            printChoiceMessage(choice);
            executeMenuItem(choice);
            if (choice == MenuItem.QUIT) {
                break;
            }
            printBooksAndFreeShelvesCountMessage();
            waitForPressingEnter();
        }
    }

    private void printGreeting() {
        typewrite("\nДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!\n");
    }

    private void typewrite(String text) {
        char[] textCharacters = text.toCharArray();
        for (char character : textCharacters) {
            System.out.print(character);
            int pause = random.nextInt(100, 200);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException ignored) {
                // Продолжаем работу без задержки
            }
        }
        System.out.println();
    }

    private void printAsBookcase(Book[] books, String header) {
        if (books.length == 0) {
            printEmptyBookcaseMessage();
            return;
        }
        int indent = (WIDTH - header.length()) / 2;
        System.out.println("\n" + " ".repeat(indent) + header);
        printSeparator();
        for (Book book : books) {
            printAsShelf(book);
            printSeparator();
        }
    }

    private static void printEmptyBookcaseMessage() {
        System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
    }

    private static void printSeparator() {
        System.out.println("+" + "-".repeat(WIDTH - 2) + "+");
    }

    private void printAsShelf(Book book) {
        int maxLineLength = BookcaseUi.WIDTH - 4;
        if (book.toString().length() > maxLineLength) {
            System.out.print(splitIntoBorderedLines(book.toString(), maxLineLength));
            return;
        }
        System.out.print(makeLineBordered(book.toString()));
    }

    public String splitIntoBorderedLines(String string, int maxLineLength) {
        char[][] lines = new char[1][];
        char[] characters = string.toCharArray();
        int lineStart = 0;
        int lineEnd = maxLineLength;
        while (lineEnd < characters.length) {
            int lastLine = lines.length - 1;

            boolean hasWhitespace = false;
            for (int i = lineEnd; i > lineStart; i--) {
                if (Character.isWhitespace(characters[i])) {
                    hasWhitespace = true;
                    lines[lastLine] = makeBorderedLine(characters, lineStart, i);
                    lineStart = i + 1;
                    lineEnd = i + 1 + maxLineLength;
                    break;
                }
            }
            if (!hasWhitespace) {
                lines[lastLine] = makeBorderedLine(characters, lineStart, lineEnd);
                lineStart += maxLineLength;
                lineEnd += maxLineLength;
            }
            lines = addNewLine(lines);
        }
        lines[lines.length - 1] = makeBorderedLine(characters, lineStart, characters.length);

        return flattenToString(lines);
    }

    private char[][] addNewLine(char[][] lines) {
        lines = Arrays.copyOf(lines, lines.length + 1);
        lines[lines.length - 1] = new char[lines[0].length];
        return lines;
    }

    private char[] makeBorderedLine(char[] characters, int lineStart, int lineEnd) {
        char[] dest = new char[BookcaseUi.WIDTH + 1];
        int srcLength = lineEnd - lineStart;
        System.arraycopy(characters, lineStart, dest, 2, srcLength);
        for (int i = (2 + srcLength); i < (dest.length - 2); i++) {
            dest[i] = ' ';
        }
        dest[0] = '|';
        dest[1] = ' ';
        dest[dest.length - 2] = '|';
        dest[dest.length - 1] = '\n';
        return dest;
    }

    private String flattenToString(char[][] characters) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : characters) {
            sb.append(row);
        }
        return sb.toString();
    }

    private String makeLineBordered(String line) {
        char[] borderedLine = makeBorderedLine(line.toCharArray(), 0, line.length());
        return String.valueOf(borderedLine);
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
        currentMenu = bookcase.getBooksCount() == 0 ? emptyBookcaseMenu
                : bookcase.getBooksCount() == Bookcase.MAX_BOOKS ? filledBookcaseMenu : fullMenu;
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
            scanner.nextLine();
            System.out.println("\nОшибка: введено не целое число.");
            return readNumber("Введите целое число: ");
        }
    }

    private static void printChoiceMessage(MenuItem choice) {
        System.out.println("Выбран пункт \"" + choice.text() + "\".\n");
    }

    private void executeMenuItem(MenuItem choice) {
        switch (choice) {
            case ADD_BOOK -> addBook();
            case FIND_BOOK -> findBook();
            case REMOVE_BOOK -> removeBook();
            case CLEAR_BOOKCASE -> clearBookcase();
            case QUIT -> {
            }
        }
    }

    private void printBooksAndFreeShelvesCountMessage() {
        System.out.printf("В шкафу книг - %d, свободно полок - %d%n",
                bookcase.getBooksCount(), bookcase.getFreeShelvesCount());
    }

    private void addBook() {
        Book book = askForBook();
        try {
            boolean isSuccess = bookcase.add(book);
            if (isSuccess) {
                System.out.println("\nКнига добавлена в шкаф.");
            } else {
                System.out.println("\nОшибка: невозможно добавить книгу, так как шкаф заполнен.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addBook();
        }

    }

    private Book askForBook() {
        String author = readCleanedLine("Введите автора книги: ");
        String title = readCleanedLine("Введите название книги: ");
        Year year = readValidPublicationYear("Введите год публикации: ");
        try {
            return new Book(author, title, year);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Попробуйте снова.\n");
            return askForBook();
        }
    }

    private String readCleanedLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim().replaceAll("\\s+", " ");
    }

    private Year readValidPublicationYear(String prompt) {
        Year year;
        while (true) {
            year = Year.of(readNumber(prompt));
            if (year.isBefore(Year.now())) {
                break;
            }
            printUnacceptableYearError();
        }
        scanner.nextLine();
        return year;
    }

    private void printUnacceptableYearError() {
        System.out.println("\nОшибка: год публикации не может быть больше текущего.");
    }

    private void findBook() {
        String title = readCleanedLine("Введите название книги: ");
        Book[] foundBooks = bookcase.find(title);
        if (foundBooks.length == 0) {
            System.out.println("\nПоиск по названию книги \"" + title + "\" не дал результата.");
            return;
        }
        printAsBookcase(foundBooks, "КНИГИ, ИМЕЮЩИЕ НАЗВАНИЕ \"" + title + "\":");
    }

    private void removeBook() {
        String title = readCleanedLine("Введите название книги, которую хотите удалить: ");
        int booksRemoved = bookcase.remove(title);
        System.out.println("Удалено книг: " + booksRemoved);
    }

    private void clearBookcase() {
        bookcase.clearAll();
        System.out.println("Шкаф очищен.");
    }

    private void waitForPressingEnter() {
        readCleanedLine("\nДля продолжения работы нажмите клавишу <Enter> ");
    }
}
