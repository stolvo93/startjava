package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final char[][] BLACKLIST = {
            ("admin").toCharArray(),
            ("qwerty").toCharArray(),
            ("123456").toCharArray()
    };
    private static final int FLAGS_NUMBER = 4;
    private static final int DIGIT_IDX = 0;
    private static final int SMALL_LETTER_IDX = 1;
    private static final int CAPITAL_LETTER_IDX = 2;
    private static final int SPECIAL_CHARACTER_IDX = 3;
    private static final int STRONG_PASSWORD_MIN_LENGTH = 8;
    private static final String[] FLAG_DESCRIPTIONS = {
            "цифры",
            "буквы нижнего регистра",
            "буквы верхнего регистра",
            "спец. символы"
    };
    private static final String ANSI_RED = "\u001B[31m"; // следующий текст будет красным
    private static final String ANSI_GREEN = "\u001B[32m"; // следующий текст будет зеленым
    private static final String ANSI_RESET = "\u001B[0m"; // следующий текст будет стандартного цвета
    private static final char[] SPINS = ("-\\|/").toCharArray();
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        char[][] passwordsToCrack = new char[4][];
        passwordsToCrack[0] = ("123456").toCharArray();
        for (int i = 1; i < passwordsToCrack.length; i++) {
            int passwordLength = random.nextInt(6, 13);
            passwordsToCrack[i] = generatePassword(passwordLength);
        }

        for (char[] password : passwordsToCrack) {
            System.out.println();
            boolean[] complexityFlags = checkComplexity(password);
            showWarnings(password, complexityFlags);
            crack(password, complexityFlags);
        }
    }

    private static char[] generatePassword(int length) {
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = (char) random.nextInt(32, 127);
        }
        return password;
    }

    private static boolean[] checkComplexity(char[] password) {
        boolean[] complexityFlags = new boolean[FLAGS_NUMBER];
        for (char character : password) {
            if (!Character.isLetterOrDigit(character) && !Character.isWhitespace(character)) {
                complexityFlags[SPECIAL_CHARACTER_IDX] = true;
            } else if (Character.isUpperCase(character)) {
                complexityFlags[CAPITAL_LETTER_IDX] = true;
            } else if (Character.isLowerCase(character)) {
                complexityFlags[SMALL_LETTER_IDX] = true;
            } else if (Character.isDigit(character)) {
                complexityFlags[DIGIT_IDX] = true;
            }
        }
        return complexityFlags;
    }

    private static void showWarnings(char[] password, boolean[] complexityFlags) {
        if (isBlacklisted(password)) {
            System.out.println("""
                    Не используйте пароли из списка популярных: \
                    https://nordpass.com/most-common-passwords-list""");
        }

        if (password.length < STRONG_PASSWORD_MIN_LENGTH) {
            System.out.printf("Пароль содержит менее %d символов%n", STRONG_PASSWORD_MIN_LENGTH);
        }
        if (isBlank(password)) {
            System.out.println("Пароль не может быть пустым");
        }

        for (int i = 0; i < FLAG_DESCRIPTIONS.length; i++) {
            if (!complexityFlags[i]) {
                System.out.println("Пароль не содержит " + FLAG_DESCRIPTIONS[i]);
            }
        }
    }

    private static boolean isBlacklisted(char[] password) {
        for (char[] weakPassword : BLACKLIST) {
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

    private static void crack(char[] password, boolean[] complexityFlags) throws InterruptedException {
        System.out.print("Cracking password:  ");
        rollSpinner();
        System.out.println();

        String message = isStrong(password, complexityFlags) ?
                ANSI_RED + "✗ Strong password: " :
                ANSI_GREEN + "✓ Password cracked: ";
        System.out.println(message + String.valueOf(password) + ANSI_RESET);
    }

    private static boolean isStrong(char[] password, boolean[] complexityFlags) {
        if (password.length < STRONG_PASSWORD_MIN_LENGTH) {
            return false;
        }
        for (boolean flag : complexityFlags) {
            if (!flag) return false;
        }
        return true;
    }

    private static void rollSpinner() throws InterruptedException {
        for (int i = 0; i < SPINS.length * 6; i++) {
            System.out.print("\b" + SPINS[i % SPINS.length]);
            Thread.sleep(150);
        }
    }
}