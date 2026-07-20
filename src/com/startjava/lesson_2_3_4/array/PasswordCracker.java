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
    private static boolean hasSmallLetters = false;
    private static boolean hasCapitalLetters = false;
    private static boolean hasDigits = false;
    private static boolean hasSpecialCharacters = false;

    public static void main(String[] args) {
        char[][] passwordsToBeCracked = new char[4][];
        passwordsToBeCracked[0] = ("123456").toCharArray();
        for (int i = 1; i < passwordsToBeCracked.length; i++) {
            int passwordLength = RND.nextInt(6, 13);
            passwordsToBeCracked[i] = generatePassword(passwordLength);
        }

        for (char[] password : passwordsToBeCracked) {
            System.out.println();
            System.out.println(password);
            checkComplexity(password);
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

    private static void checkComplexity(char[] password) {
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
            System.out.println(beginning.toString() + "содержит менее 8 символов");
        }
        if (isBlank(password)) {
            System.out.println(beginning.toString() + "не может быть пустым");
        }
        beginning.append("не содержит ");
        if (!hasDigits) {
            System.out.println(beginning.toString() + "цифры");
        }
        if (!hasCapitalLetters) {
            System.out.println(beginning.toString() + "буквы верхнего регистра");
        }
        if (!hasSmallLetters) {
            System.out.println(beginning.toString() + "буквы нижнего регистра");
        }
        if (!hasSpecialCharacters) {
            System.out.println(beginning.toString() + "спец. символы");
        }
    }

    private static boolean isBlank(char[] password) {
        for (char character : password) {
            if (!Character.isWhitespace(character)) {
                return false;
            }
        }
        return true;
    }

    private static void crack(char[] password) {
        System.out.print("Cracking password: ");
        // rollSpinner();

        String message = "✓ Password cracked: ";

        if (password.length >= 8 && hasSmallLetters && hasCapitalLetters && hasSpecialCharacters) {
            message = "✗ Strong password: ";
        } // else if (password.length() >= 8 && (hasCapitalLetters || hasDigits)) {
        //     passwordStrength = "Средний";
        // }

        // System.out.println("Пароль: " + password);
        // System.out.println("Надёжность: " + passwordStrength);

        System.out.println(message + '\'' + String.valueOf(password) + '\'');
    }
}