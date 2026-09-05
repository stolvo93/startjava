package com.startjava.lesson_2_3_4.guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 10;
    private static final int ROUNDS_COUNT = 3;
    private static final char[] spinnerFrames = {'-', '\\', '|', '/'};
    private final Player[] players;
    private final Random random = new Random();
    private final Scanner scanner;
    private int targetNumber;
    private Player currentPlayer;

    public GuessNumber(Scanner scanner, Player... players) {
        this.scanner = scanner;
        this.players = players.clone();
    }

    public void play() {
        initGame();
        for (int round = 1; round <= ROUNDS_COUNT; round++) {
            playRound(round);
            printCurrentScore();
            printRoundGuessHistory();
        }
        showGameResult();
    }

    private void initGame() {
        resetScores();
        printGreeting();
        showDrawingLots();
        shufflePlayers();
        announcePlayerOrder();
    }

    private void resetScores() {
        for (Player player : players) {
            player.resetScore();
        }
    }

    private void printGreeting() {
        System.out.println("\n***** УГАДАЙ ЧИСЛО *****");
    }

    private void showDrawingLots() {
        System.out.print("\nИгроки бросают жребий:  ");
        rollSpinner();
    }

    private void rollSpinner() {
        int totalFrames = spinnerFrames.length * 6;
        for (int i = 0; i < totalFrames; i++) {
            System.out.print("\b" + spinnerFrames[i % spinnerFrames.length]);
            try {
                Thread.sleep(150);
            } catch (InterruptedException ignored) {
                // Продолжаем работу без задержки
            }
        }
    }

    private void shufflePlayers() {
        int len = players.length;
        for (int i = len - 1; i >= 1; i--) {
            int r = random.nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[r];
            players[r] = temp;
        }
    }

    private void announcePlayerOrder() {
        System.out.println("\n\nОпределён следующий порядок ходов игроков:");
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

    private void playRound(int round) {
        initRound(round);
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            playAttempt(attempt);
            if (isGuessed()) {
                currentPlayer.addPoint();
                printRoundVictoryMessage(attempt);
                break;
            }
        }
        printRoundFinishMessage(round);
        if (!isGuessed()) printAllLoseRoundMessage();
    }

    private void initRound(int round) {
        resetAttempts();
        generateTargetNumber();
        printRoundStartMessage(round);
    }

    private void resetAttempts() {
        for (Player player : players) {
            player.resetAttempts();
        }
    }

    private void generateTargetNumber() {
        targetNumber = random.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    private void printRoundStartMessage(int round) {
        System.out.printf("\nРаунд %d. У каждого игрока по %d попыток%n", round, MAX_ATTEMPTS);
    }

    private void playAttempt(int attempt) {
        for (Player player : players) {
            currentPlayer = player;
            makeGuess(attempt);
            if (isGuessed()) return;
            printWrongGuessMessage();
            if (attempt == MAX_ATTEMPTS) printOutOfAttemptsMessage();
        }
    }

    private void makeGuess(int attempt) {
        System.out.println("\nПопытка " + attempt);
        int playerNumber = readNumber("Число вводит " + currentPlayer.getName() + ": ");
        while (true) {
            try {
                currentPlayer.addTriedNumber(playerNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                playerNumber = readNumberAgain();
            }
        }
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
        return currentPlayer.getLatestNumber() == targetNumber;
    }

    private void printWrongGuessMessage() {
        int playerNumber = currentPlayer.getLatestNumber();
        String inequalitySignWord = playerNumber < targetNumber ? "меньше" : "больше";
        System.out.printf("%d %s того, что загадал компьютер%n", playerNumber, inequalitySignWord);
    }

    private void printOutOfAttemptsMessage() {
        System.out.println("У игрока " + currentPlayer.getName() + " закончились попытки!");
    }

    private void printRoundVictoryMessage(int attempt) {
        System.out.printf("%n%s угадывает число %d с %d-й попытки%n",
                currentPlayer.getName(), targetNumber, attempt);
    }

    private void printRoundFinishMessage(int round) {
        System.out.println("\nРаунд " + round + " окончен!");
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

    private void showGameResult() {
        printGameResultPrefix();
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

    private void printGameResultPrefix() {
        System.out.printf("По результатам %d раундов ", ROUNDS_COUNT);
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
        System.out.println("все игроки проиграли.");
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
        System.out.println("никто не стал единоличным победителем.");
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
        System.out.println("побеждает " + winner.getName() + "!");
    }
}