package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 10;
    private final Scanner scanner;
    private final Player[] players;
    private int targetNumber;
    private int currentAttempt;
    private int lastAttempt;
    private Player currentPlayer;

    public GuessNumber(Scanner scanner, Player... players) {
        this.scanner = scanner;
        this.players = players.clone();
    }

    public void play() {
        generateTargetNumber();
        printGameStartMessage();
        for (currentAttempt = 1; currentAttempt <= MAX_ATTEMPTS; currentAttempt++) {
            for (Player player : players) {
                currentPlayer = player;
                makeMove();
                currentPlayer.addTriedNumber(currentAttempt);
                if (isGuessed()) {
                    break;
                }
                printWrongGuessMessage();
                if (currentAttempt == MAX_ATTEMPTS) {
                    printOutOfAttemptsMessage();
                }
            }
            lastAttempt = currentAttempt;
            if (isGuessed()) {
                printVictoryMessage();
                break;
            }
        }
        for (Player player : players) {
            printGuessesHistory(player);
        }
    }

    private void generateTargetNumber() {
        targetNumber = MIN_NUMBER + (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
    }

    private void printGameStartMessage() {
        System.out.printf("""
                %n***** УГАДАЙ ЧИСЛО *****%n
                Игра началась! У каждого игрока по %d попыток
                """, MAX_ATTEMPTS);
    }

    private void makeMove() {
        System.out.println("\nПопытка " + currentAttempt);
        int playerNumber = readNumber("Число вводит " + currentPlayer.getName() + ": ");
        while (true) {
            try {
                currentPlayer.setNumber(playerNumber);
                break;
            } catch (NumberNotInRangeException e) {
                System.out.println(e.getMessage());
                playerNumber = readNumber("Попробуйте ещё раз:");
            }
        }
    }

    private int readNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private boolean isGuessed() {
        return currentPlayer.getNumber() == targetNumber;
    }

    private void printWrongGuessMessage() {
        String wrongGuessMessage = "%d %s того, что загадал компьютер%n";
        String inequalitySignWord = currentPlayer.getNumber() < targetNumber ? "меньше" : "больше";
        System.out.printf(wrongGuessMessage, currentPlayer.getNumber(), inequalitySignWord);
    }

    private void printOutOfAttemptsMessage() {
        System.out.println("У игрока " + currentPlayer.getName() + " закончились попытки!");
    }

    private void printVictoryMessage() {
        System.out.printf("%n%s угадал число %d с %d-й попытки%n",
                currentPlayer.getName(), currentPlayer.getNumber(), lastAttempt);
    }

    private void printGuessesHistory(Player player) {
        StringBuilder history = new StringBuilder(String.format("%nЧисла игрока %s:%n", player.getName()));
        int[] numbers = player.getTriedNumbers(lastAttempt);
        for (int i = 0; i < numbers.length; i++) {
            history.append(numbers[i]).append(' ');
            int firstLineEnd = (int) Math.ceil(numbers.length / 2d) - 1;
            if (i == firstLineEnd) {
                history.append('\n');
            }
        }
        System.out.println(history);
    }
}