package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final char[][] BLACK_LIST = {
            ("admin").toCharArray(),
            ("qwerty").toCharArray(),
            ("123456").toCharArray()
    };
    private static final Random RND = new Random();
    private static final String ANSI_RED = "\u001B[31m"; // следующий текст будет красным
    private static final String ANSI_GREEN = "\u001B[32m"; // следующий текст будет зеленым
    private static final String ANSI_RESET = "\u001B[0m"; // следующий текст будет стандартного цвета
    private static final char[] SPINS = ("-\\|/").toCharArray();
    private static boolean hasSmallLetters;
    private static boolean hasCapitalLetters;
    private static boolean hasDigits;
    private static boolean hasSpecialCharacters;

    public static void main(String[] args) throws InterruptedException {
        char[][] passwordsToBeCracked = new char[4][];
        passwordsToBeCracked[0] = ("123456").toCharArray();
        for (int i = 1; i < passwordsToBeCracked.length; i++) {
            int passwordLength = RND.nextInt(6, 13);
            passwordsToBeCracked[i] = generatePassword(passwordLength);
        }

        for (char[] password : passwordsToBeCracked) {
            System.out.println();
            analyzeComplexity(password);
            showWarnings(password);
            crack(password);
        }
    }

    private static char[] generatePassword(int length) {
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            password[i] = (char) RND.nextInt(32, 127);
        }
        return password;
    }

    private static void analyzeComplexity(char[] password) {
        hasSpecialCharacters = false;
        hasCapitalLetters = false;
        hasSmallLetters = false;
        hasDigits = false;

        for (char character : password) {
            if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacters = true;
            } else if (Character.isUpperCase(character)) {
                hasCapitalLetters = true;
            } else if (Character.isLowerCase(character)) {
                hasSmallLetters = true;
            } else {
                hasDigits = true;
            }
        }
    }

    private static void showWarnings(char[] password) {
        boolean isPasswordBlacklisted = false;
        for (char[] weakPassword : BLACK_LIST) {
            if (Arrays.equals(password, weakPassword)) {
                isPasswordBlacklisted = true;
                break;
            }
        }
        if (isPasswordBlacklisted) {
            System.out.println("""
                    Не используйте пароли из списка популярных: \
                    https://nordpass.com/most-common-passwords-list
                    """);
        }
        StringBuilder beginning = new StringBuilder("Пароль ");
        if (password.length < 8) {
            System.out.println(beginning + "содержит менее 8 символов");
        }
        if (isBlank(password)) {
            System.out.println(beginning + "не может быть пустым");
        }
        beginning.append("не содержит ");
        if (!hasDigits) {
            System.out.println(beginning + "цифры");
        }
        if (!hasCapitalLetters) {
            System.out.println(beginning + "буквы верхнего регистра");
        }
        if (!hasSmallLetters) {
            System.out.println(beginning + "буквы нижнего регистра");
        }
        if (!hasSpecialCharacters) {
            System.out.println(beginning + "спец. символы");
        }
    }

    private static boolean isBlank(char[] password) {
        if (password.length == 0) {
            return true;
        }
        for (char character : password) {
            if (!Character.isWhitespace(character)) {
                return false;
            }
        }
        return true;
    }

    private static void crack(char[] password) throws InterruptedException {
        System.out.print("Cracking password: ");
        rollSpinner();
        System.out.println();

        String message = ANSI_GREEN + "✓ Password cracked: ";
        if (password.length >= 8 && hasSmallLetters && hasCapitalLetters && hasSpecialCharacters) {
            message = ANSI_RED + "✗ Strong password: ";
        }
        System.out.println(message + String.valueOf(password) + ANSI_RESET);
    }

    private static void rollSpinner() throws InterruptedException {
        for (int turn = 1, spinIndex = 0; turn <= 3; spinIndex++) {
            if (spinIndex == SPINS.length) {
                spinIndex = -1;
                turn++;
                continue;
            }
            System.out.print(SPINS[spinIndex]);
            Thread.sleep(100);
            System.out.print('\b');
        }
    }
}