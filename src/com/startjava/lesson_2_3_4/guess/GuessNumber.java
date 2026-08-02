package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    private final Player[] players;
    private final Scanner scanner;
    private int targetNumber;
    private Player currentPlayer;
    private int currentPlayerIndex;

    public GuessNumber(Scanner scanner, Player... players) {
        this.scanner = scanner;
        this.players = players.clone();
        currentPlayerIndex = 0;
    }

    public void play() {
        generateTargetNumber();
        currentPlayer = players[currentPlayerIndex];
        while (true) {
            makeMove();
            if (isGuessed()) {
                break;
            }
            printFailureMessage();
            changePlayer();
        }
        printVictoryMessage();
    }

    private void generateTargetNumber() {
        targetNumber = MIN_NUMBER + (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
        System.out.printf("\nКомпьютер загадал число в диапазоне [%d, %d]. Попробуйте его угадать!%n",
                MIN_NUMBER, MAX_NUMBER);
    }

    private void makeMove() {
        System.out.println("\nХод игрока " + currentPlayer.getName());
        readNumber();
        currentPlayer.setNumber();
    }

    private void readNumber() {
        System.out.print("Введите число: ");
        currentPlayer.setNumber(scanner.nextInt());
    }

    private boolean isNumberInRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private void printOutOfRangeWarning() {
        System.out.printf("Внимание! Число должно быть в диапазоне [%d, %d]. Введите другое число.%n",
                MIN_NUMBER, MAX_NUMBER);
    }

    private boolean isGuessed() {
        return currentPlayer.getNumber() == targetNumber;
    }

    private void printFailureMessage() {
        String failureMessage = "%d %s того, что загадал компьютер%n";
        String inequalitySignWord = currentPlayer.getNumber() < targetNumber ? "меньше" : "больше";
        System.out.printf(failureMessage, currentPlayer.getNumber(), inequalitySignWord);
    }

    private void changePlayer() {
        currentPlayerIndex++;
        currentPlayer = players[currentPlayerIndex];
    }

    private void printVictoryMessage() {
        System.out.printf("\nИскомое число - %d. Побеждает игрок %s!%n%n",
                currentPlayer.getNumber(), currentPlayer.getName());
    }
}