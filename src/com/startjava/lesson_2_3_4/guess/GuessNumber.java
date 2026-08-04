package com.startjava.lesson_2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {
    private static final int ROUNDS_NUMBER = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 10;
    private final Scanner scanner;
    private final Player[] players;
    private int targetNumber;
    private int currentAttempt;
    private Player currentPlayer;

    public GuessNumber(Scanner scanner, Player... players) {
        this.scanner = scanner;
        this.players = players.clone();
    }

    public void play() {
        generateTargetNumber();
        printGameStartMessage();
        for (int currentRound = 1; currentRound <= ROUNDS_NUMBER; currentRound++) {
            for (currentAttempt = 1; currentAttempt <= MAX_ATTEMPTS; currentAttempt++) {
                for (Player player : players) {
                    currentPlayer = player;
                    makeGuess();
                    // writeStats();
                    if (isGuessed()) break;
                    printWrongGuessMessage();
                    if (currentAttempt == MAX_ATTEMPTS) printOutOfAttemptsMessage();
                }
                if (isGuessed()) {
                    currentPlayer.addPoint();
                    printRoundVictoryMessage();
                    break;
                }
                printAllLoseRoundMessage();
            }
            printGuessHistory();
            printRoundFinishMessage(currentRound);
            printRoundScore();
        }
        if (isAllLoseGame()) {
            printAllLoseGameMessage();
            return;
        }
        int maxScore = findMaxScore();
        if (isDraw(maxScore)) {
            printDrawMessage();
            return;
        }
        Player winner = determineWinner(maxScore);
        printGameVictoryMessage(winner);
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

    private void makeGuess() {
        System.out.println("\nПопытка " + currentAttempt);
        int playerNumber = readNumber("Число вводит " + currentPlayer.getName() + ": ");
        while (true) {
            try {
                currentPlayer.setNumber(playerNumber);
                break;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
                playerNumber = readNumber("Попробуйте ещё раз: ");
            }
        }
        currentPlayer.setLatestAttempt(currentAttempt);
        currentPlayer.addTriedNumber();
    }

    // private void writeStats() {
    // }

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

    private void printRoundVictoryMessage() {
        System.out.printf("%n%s угадывает число %d с %d-й попытки%n",
                currentPlayer.getName(), currentPlayer.getNumber(), currentPlayer.getLatestAttempt());
    }

    private void printAllLoseRoundMessage() {
        System.out.println("Никто не угадал число " + targetNumber);
    }

    private void printGuessHistory() {
        for (Player player : players) {
            StringBuilder history = new StringBuilder(String.format("%nЧисла игрока %s: ", player.getName()));
            int[] numbers = player.getTriedNumbers();
            for (int number : numbers) {
                history.append(number).append(' ');
            }
            System.out.println(history);
        }
    }

    private void printRoundFinishMessage(int currentRound) {
        System.out.println("Раунд " + currentRound + " окончен!");
    }

    private void printRoundScore() {
        StringBuilder score = new StringBuilder("Счёт по итогам раунда:\n");
        for (Player player : players) {
            score.append(player.getName()).append(": ").append(player.getScore()).append('\n');
        }
        System.out.println(score);
    }

    private boolean isAllLoseGame() {
        for (Player player : players) {
            if (player.getScore() != 0) {
                return false;
            }
        }
        return true;
    }

    private void printAllLoseGameMessage() {
        System.out.println("Общий проигрыш.");
    }

    private int findMaxScore() {
        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }
        return maxScore;
    }

    private boolean isDraw(int maxScore) {
        if (players.length < 2) {
            return false;
        }
        int maxScoreCount = 0;
        for (Player player : players) {
            if (player.getScore() == maxScore) maxScoreCount++;
        }
        return maxScoreCount > 1;
    }

    private void printDrawMessage() {
        System.out.println("Никто не стал победителем.");
    }

    private Player determineWinner(int maxScore) {
        Player winner = null;
        for (Player player : players) {
            if (player.getScore() == maxScore) {
                winner = player;
            }
        }
        return winner;
    }

    private void printGameVictoryMessage(Player winner) {
        System.out.println("Побеждает " + winner.getName() + "!");
    }
}