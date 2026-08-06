package com.startjava.lesson_2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {
    private static final int ROUNDS_NUMBER = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 3;
    private final Scanner scanner;
    private final Player[] players;
    private int targetNumber;
    private int currentRound;
    private int currentAttempt;
    private Player currentPlayer;

    public GuessNumber(Scanner scanner, Player... players) {
        this.scanner = scanner;
        this.players = players.clone();
    }

    public void play() {
        for (currentRound = 1; currentRound <= ROUNDS_NUMBER; currentRound++) {
            playRound();
            printCurrentScore();
            printRoundGuessHistory();
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

    private void playRound() {
        cleanUpState();
        generateTargetNumber();
        printRoundStartMessage();
        for (currentAttempt = 1; currentAttempt <= MAX_ATTEMPTS; currentAttempt++) {
            playAttempt();
            if (isGuessed()) {
                currentPlayer.addPoint();
                printRoundVictoryMessage();
                break;
            }
        }
        printRoundFinishMessage();
        if (!isGuessed()) {
            printAllLoseRoundMessage();
        }
    }

    private void cleanUpState() {
        for (Player player : players) {
            player.setLatestAttempt(0);
        }
    }

    private void generateTargetNumber() {
        targetNumber = MIN_NUMBER + (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
        // targetNumber = 100;
    }

    private void printRoundStartMessage() {
        System.out.printf("""
                %n***** УГАДАЙ ЧИСЛО *****%n
                Раунд %d. У каждого игрока по %d попыток
                """, currentRound, MAX_ATTEMPTS);
    }

    private void playAttempt() {
        for (Player player : players) {
            currentPlayer = player;
            makeGuess();
            if (isGuessed()) return;
            printWrongGuessMessage();
            if (currentAttempt == MAX_ATTEMPTS) printOutOfAttemptsMessage();
        }
    }

    private void makeGuess() {
        System.out.println("\nПопытка " + currentAttempt);
        int playerNumber = readNumber("Число вводит " + currentPlayer.getName() + ": ");
        while (true) {
            try {
                currentPlayer.setNumber(playerNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                playerNumber = readNumberAgain();
            }
        }
        currentPlayer.setLatestAttempt(currentAttempt);
        currentPlayer.addTriedNumber();
    }

    private int readNumber(String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("\nОшибка: введите целое число.");
            return readNumberAgain();
        }
    }

    private int readNumberAgain() {
        return readNumber("Попробуйте ещё раз: ");
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

    private void printRoundFinishMessage() {
        System.out.println("\nРаунд " + currentRound + " окончен!");
    }

    private void printAllLoseRoundMessage() {
        System.out.println("Никто не угадал число " + targetNumber);
    }

    private void printCurrentScore() {
        StringBuilder score = new StringBuilder("\nТекущий счёт:\n");
        for (Player player : players) {
            score.append(player.getName()).append(": ").append(player.getScore()).append('\n');
        }
        System.out.println(score);
    }

    private void printRoundGuessHistory() {
        for (Player player : players) {
            StringBuilder history = new StringBuilder(String.format("Числа игрока %s: ", player.getName()));
            int[] numbers = player.getTriedNumbers();
            for (int number : numbers) {
                history.append(number).append(' ');
            }
            System.out.println(history);
        }
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
        System.out.println("\nОбщий проигрыш.");
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
        System.out.println("\nНикто не стал единоличным победителем.");
    }

    private Player determineWinner(int maxScore) {
        for (Player player : players) {
            if (player.getScore() == maxScore) {
                return player;
            }
        }
        return null;
    }

    private void printGameVictoryMessage(Player winner) {
        System.out.println("\nПобеждает " + winner.getName() + "!");
    }
}