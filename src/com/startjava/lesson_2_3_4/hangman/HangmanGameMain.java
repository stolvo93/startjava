package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
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
        String answer = scanner.nextLine().trim().toLowerCase();
        if (!"yes".equals(answer) && !"no".equals(answer)) {
            return askToContinue(scanner, "Введите корректный ответ [yes / no]: ");
        }
        return answer;
    }
}
