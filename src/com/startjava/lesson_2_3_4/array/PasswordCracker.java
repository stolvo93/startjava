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
    private static final int HAS_DIGITS = 0;
    private static final int HAS_SMALL_LETTERS = 1;
    private static final int HAS_CAPITAL_LETTERS = 2;
    private static final int HAS_SPECIAL_CHARACTERS = 3;
    private static final int IS_STRONG_PASSWORD = 4;
    private static final String ANSI_RED = "\u001B[31m"; // следующий текст будет красным
    private static final String ANSI_GREEN = "\u001B[32m"; // следующий текст будет зеленым
    private static final String ANSI_RESET = "\u001B[0m"; // следующий текст будет стандартного цвета
    private static final char[] SPINS = ("-\\|/").toCharArray();
    private static final int MIN_FULL_TURNS = 3;

    public static void main(String[] args) throws InterruptedException {
        char[][] passwordsToCrack = new char[4][];
        passwordsToCrack[0] = ("123456").toCharArray();
        for (int i = 1; i < passwordsToCrack.length; i++) {
            int passwordLength = RND.nextInt(6, 13);
            passwordsToCrack[i] = generatePassword(passwordLength);
        }

        for (char[] password : passwordsToCrack) {
            System.out.println();
            boolean[] complexityFlags = checkComplexity(password);
            showWarnings(password, complexityFlags);
            crack(password, complexityFlags[IS_STRONG_PASSWORD]);
        }
    }

    private static char[] generatePassword(int length) {
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = (char) RND.nextInt(32, 127);
        }
        return password;
    }

    private static boolean[] checkComplexity(char[] password) {
        boolean[] complexityFlags = new boolean[5];
        for (char character : password) {
            if (!Character.isLetterOrDigit(character)) {
                complexityFlags[HAS_SPECIAL_CHARACTERS] = true;
            } else if (Character.isUpperCase(character)) {
                complexityFlags[HAS_CAPITAL_LETTERS] = true;
            } else if (Character.isLowerCase(character)) {
                complexityFlags[HAS_SMALL_LETTERS] = true;
            } else if (Character.isDigit(character)) {
                complexityFlags[HAS_DIGITS] = true;
            }
        }
        if (password.length >= 8 &&
                complexityFlags[HAS_SMALL_LETTERS] &&
                complexityFlags[HAS_CAPITAL_LETTERS] &&
                complexityFlags[HAS_SPECIAL_CHARACTERS]) {
            complexityFlags[IS_STRONG_PASSWORD] = true;
        }
        return complexityFlags;
    }

    private static void showWarnings(char[] password, boolean[] complexityFlags) {
        if (isBlacklisted(password)) {
            System.out.println("""
                    Не используйте пароли из списка популярных: \
                    https://nordpass.com/most-common-passwords-list""");
        }

        StringBuilder beginning = new StringBuilder("Пароль ");
        if (password.length < 8) {
            System.out.println(beginning + "содержит менее 8 символов");
        }
        if (isBlank(password)) {
            System.out.println(beginning + "не может быть пустым");
        }
        beginning.append("не содержит ");
        if (!complexityFlags[HAS_DIGITS]) {
            System.out.println(beginning + "цифры");
        }
        if (!complexityFlags[HAS_CAPITAL_LETTERS]) {
            System.out.println(beginning + "буквы верхнего регистра");
        }
        if (!complexityFlags[HAS_SMALL_LETTERS]) {
            System.out.println(beginning + "буквы нижнего регистра");
        }
        if (!complexityFlags[HAS_SPECIAL_CHARACTERS]) {
            System.out.println(beginning + "спец. символы");
        }
    }

    private static boolean isBlacklisted(char[] password) {
        for (char[] weakPassword : BLACK_LIST) {
            if (Arrays.equals(password, weakPassword)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBlank(char[] password) {
        for (char character : password) {
            if (!Character.isWhitespace(character)) {
                return false;
            }
        }
        return true;
    }

    private static void crack(char[] password, boolean strongPassword)
            throws InterruptedException {
        System.out.print("Cracking password: ");
        rollSpinner();
        System.out.println();

        String message = strongPassword ?
                ANSI_RED + "✗ Strong password: " :
                ANSI_GREEN + "✓ Password cracked: ";
        System.out.println(message + String.valueOf(password) + ANSI_RESET);
    }

    private static void rollSpinner() throws InterruptedException {
        for (int halfTurn = 1, spinIndex = 0; halfTurn / 2 <= MIN_FULL_TURNS; spinIndex++) {
            if (spinIndex == SPINS.length) {
                spinIndex = -1;
                halfTurn++;
                continue;
            }
            System.out.print(SPINS[spinIndex]);
            Thread.sleep(100);
            System.out.print('\b');
        }
    }
}