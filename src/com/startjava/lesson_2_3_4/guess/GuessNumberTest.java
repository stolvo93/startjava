package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static int PLAYERS_NUMBER = 3;

    public static void main(String[] args) {
        String[] names = {
                "Петя",
                "Вася",
                "Катя",
        };
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[PLAYERS_NUMBER];
        for (int i = 0; i < PLAYERS_NUMBER; i++) {
            String name = names[i]; //readName(scanner, "\nВведите имя игрока " + (i + 1) + ": ");
            players[i] = new Player(name);
        }

        GuessNumber game = new GuessNumber(scanner, players);
        String answer;
        do {
            game.play();
            scanner.nextLine();
            do {
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while ("yes".equals(answer));
    }

    private static String readName(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}