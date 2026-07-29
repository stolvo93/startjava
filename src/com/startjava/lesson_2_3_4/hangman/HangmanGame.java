package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class HangmanGame {
    private static final char[][] TARGET_WORDS = {
            "ДОЛЖНОСТЬ".toCharArray(),
            "ЦИФЕРБЛАТ".toCharArray(),
            "ПОВЫШЕНИЕ".toCharArray(),
            "ЧЕМПИОНАТ".toCharArray(),
            "ОСНАЩЕНИЕ".toCharArray(),
            "ГОРОЖАНИН".toCharArray(),
            "ХОЗЯЙСТВО".toCharArray(),
            "ЭКСКУРСИЯ".toCharArray(),
            "ПОДЪЁМНИК".toCharArray(),
            "ЮНОШЕСТВО".toCharArray(),
    };
    private static final String[] GALLOWS = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final int MAX_ATTEMPTS = GALLOWS.length;
    private static final char MASK_CHAR = '_';
    private static final Random random = new Random();
    private final Scanner scanner;
    private final char[] targetWord;
    private final char[] targetWordMask;
    private int attemptsNumber;
    private char[] wrongLetters;

    public HangmanGame(Scanner scanner) {
        this.scanner = scanner;
        targetWord = TARGET_WORDS[random.nextInt(TARGET_WORDS.length)].clone();
        targetWordMask = createMask(targetWord.length);
        attemptsNumber = MAX_ATTEMPTS;
        wrongLetters = new char[0];
    }

    private char[] createMask(int len) {
        char[] mask = new char[len];
        Arrays.fill(mask, MASK_CHAR);
        return mask;
    }

    public void play() {
        printGreeting();
        while (attemptsNumber > 0) {
            showInfo();
            char playerLetter = readValidLetter();
            applyGuess(playerLetter);
            if (isWordGuessed()) {
                printVictoryMessage();
                return;
            }
        }
        printLossMessage();
        printGallowsPart();
    }

    private void printGreeting() {
        System.out.println("\n    *** Игра ВИСЕЛИЦА ***");
    }

    private void showInfo() {
        System.out.println();
        printGallowsPart();
        printTargetWordMaskMessage();
        printAttemptsNumberMessage();
        printWrongLettersMessage();
    }

    private void printGallowsPart() {
        for (int i = 0; i < GALLOWS.length - attemptsNumber; i++) {
            System.out.println(GALLOWS[i]);
        }
    }

    private void printTargetWordMaskMessage() {
        System.out.println("Угадываемое слово: " + String.valueOf(targetWordMask));
    }

    private void printAttemptsNumberMessage() {
        System.out.println("Количество попыток: " + attemptsNumber);
    }

    private void printWrongLettersMessage() {
        if (wrongLetters.length > 0) {
            StringJoiner message = new StringJoiner(", ", "Ошибочные буквы: ", "");
            for (char letter : wrongLetters) {
                message.add(String.valueOf(letter));
            }
            System.out.println(message);
        }
    }

    private char readValidLetter() {
        String input = readString("Введите букву: ");
        while (true) {
            if (input.length() != 1) {
                input = readString("\nПожалуйста, введите строго ОДНУ букву: ");
                continue;
            }
            char inputChar = input.charAt(0);
            if (!isCyrillic(inputChar)) {
                printNotCyrillicWarning();
                input = readString("Введите кириллическую букву: ");
                continue;
            }
            if (isAlreadyUsed(inputChar)) {
                printAlreadyUsedWarning();
                input = readString("Введите не использованную ранее букву: ");
                continue;
            }
            return Character.toUpperCase(inputChar);
        }
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private boolean isCyrillic(char value) {
        return value >= 'а' && value <= 'я' ||
                value >= 'А' && value <= 'Я' ||
                value == 'ё' || value == 'Ё';
    }

    private void printNotCyrillicWarning() {
        System.out.println("\nВведённый символ не является кириллической буквой.");
    }

    private boolean isAlreadyUsed(char letter) {
        letter = Character.toUpperCase(letter);
        for (char maskLetter : targetWordMask) {
            if (letter == maskLetter) return true;
        }
        for (char wrongLetter : wrongLetters) {
            if (letter == wrongLetter) return true;
        }
        return false;
    }

    private void printAlreadyUsedWarning() {
        System.out.println("\nВведённая буква уже была использована ранее.");
    }

    private void applyGuess(char playerLetter) {
        if (isCorrectGuess(playerLetter)) {
            attemptsNumber = Math.min(attemptsNumber + 1, MAX_ATTEMPTS);
            openGuessedLetter(playerLetter);
        } else {
            attemptsNumber--;
            wrongLetters = Arrays.copyOf(wrongLetters, wrongLetters.length + 1);
            wrongLetters[wrongLetters.length - 1] = playerLetter;
        }
    }

    private boolean isCorrectGuess(char playerLetter) {
        for (char letter : targetWord) {
            if (playerLetter == letter) return true;
        }
        return false;
    }

    private void openGuessedLetter(char guessedLetter) {
        for (int i = 0; i < targetWord.length; i++) {
            if (guessedLetter == targetWord[i]) {
                targetWordMask[i] = guessedLetter;
            }
        }
    }

    private boolean isWordGuessed() {
        for (char symbol : targetWordMask) {
            if (symbol == MASK_CHAR) return false;
        }
        return true;
    }

    private void printVictoryMessage() {
        System.out.println("\nСлово " + String.valueOf(targetWord) + " разгадано!");
    }

    private void printLossMessage() {
        System.out.println("\nИгра окончена. Загаданное слово: " + String.valueOf(targetWord));
    }
}