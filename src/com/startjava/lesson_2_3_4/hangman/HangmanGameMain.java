package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    private HangmanGameMain() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            HangmanGame game = new HangmanGame(scanner);
            game.play();
            answer = askToContinue(scanner);
        } while ("yes".equals(answer));
    }

    private static String askToContinue(Scanner scanner) {
        return askToContinue(scanner, "\nХотите продолжить? [yes / no]: ");
    }

    private static String askToContinue(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String answer = toLowerCase(scanner.nextLine().trim());
        if (!"yes".equals(answer) && !"no".equals(answer)) {
            return askToContinue(scanner, "Введите корректный ответ [yes / no]: ");
        }
        return answer;
    }

    private static String toLowerCase(String string) {
        char[] stringChars = string.toCharArray();
        for (int i = 0; i < stringChars.length; i++) {
            stringChars[i] = Character.toLowerCase(stringChars[i]);
        }
        return String.valueOf(stringChars);
    }
}
