package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final char[][] BLACKLIST = {
            ("admin").toCharArray(),
            ("qwerty").toCharArray(),
            ("123456").toCharArray()
    };
    private static final int HAS_DIGIT = 0;
    private static final int HAS_SMALL_LETTER = 1;
    private static final int HAS_CAPITAL_LETTER = 2;
    private static final int HAS_SPECIAL_CHARACTER = 3;
    private static final int IS_STRONG_PASSWORD = 4;
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
        passwordsToCrack[0] = ("Abcdef1 ").toCharArray();
        for (int i = 1; i < passwordsToCrack.length; i++) {
            int passwordLength = random.nextInt(6, 13);
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
            password[i] = (char) random.nextInt(32, 127);
        }
        return password;
    }

    private static boolean[] checkComplexity(char[] password) {
        boolean[] complexityFlags = new boolean[5];
        for (char character : password) {
            if (!Character.isLetterOrDigit(character)) {
                complexityFlags[HAS_SPECIAL_CHARACTER] = true;
            } else if (Character.isUpperCase(character)) {
                complexityFlags[HAS_CAPITAL_LETTER] = true;
            } else if (Character.isLowerCase(character)) {
                complexityFlags[HAS_SMALL_LETTER] = true;
            } else if (Character.isDigit(character)) {
                complexityFlags[HAS_DIGIT] = true;
            }
        }
        if (password.length >= 8 &&
                complexityFlags[HAS_SPECIAL_CHARACTER] &&
                complexityFlags[HAS_CAPITAL_LETTER] &&
                complexityFlags[HAS_SMALL_LETTER] &&
                complexityFlags[HAS_DIGIT]) {
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

        if (password.length < 8) {
            System.out.println("Пароль содержит менее 8 символов");
        }
        if (isBlank(password)) {
            System.out.println("Пароль не может быть пустым");
        }
        // if (!complexityFlags[HAS_DIGIT]) {
        //     System.out.println("Пароль не содержит цифры");
        // }
        // if (!complexityFlags[HAS_CAPITAL_LETTER]) {
        //     System.out.println("Пароль не содержит буквы верхнего регистра");
        // }
        // if (!complexityFlags[HAS_SMALL_LETTER]) {
        //     System.out.println("Пароль не содержит буквы нижнего регистра");
        // }
        // if (!complexityFlags[HAS_SPECIAL_CHARACTER]) {
        //     System.out.println("Пароль не содержит спец. символы");
        // }

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

    private static void crack(char[] password, boolean strongPassword)
            throws InterruptedException {
        System.out.print("Cracking password:  ");
        rollSpinner();
        System.out.println();

        String message = strongPassword ?
                ANSI_RED + "✗ Strong password: " :
                ANSI_GREEN + "✓ Password cracked: ";
        System.out.println(message + String.valueOf(password) + ANSI_RESET);
    }

    private static void rollSpinner() throws InterruptedException {
        for (int i = 0; i < SPINS.length * 3; i++) {
            System.out.print("\b" + SPINS[i % SPINS.length]);
            Thread.sleep(250);
        }
    }
}