package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int PLAYERS_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = createPlayers(scanner);
        GuessNumber game = new GuessNumber(scanner, players);
        String answer;
        do {
            game.play();
            scanner.nextLine();
            answer = askToContinue(scanner);
        } while ("yes".equals(answer));
    }

    private static Player[] createPlayers(Scanner scanner) {
        Player[] players = new Player[PLAYERS_COUNT];
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            String name = readName(scanner, "\nВведите имя игрока " + (i + 1) + ": ");
            players[i] = new Player(name);
        }
        return players;
    }

    private static String readName(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static String askToContinue(Scanner scanner) {
        return askToContinue(scanner, "\nХотите повторить игру? [yes / no]: ");
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