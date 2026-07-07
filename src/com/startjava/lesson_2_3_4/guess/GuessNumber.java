package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player player1;
    private final Player player2;
    private final Scanner scanner;
    private final int minNumber = 1;
    private final int maxNumber = 100;
    private int targetNumber;
    private Player currentPlayer;

    public GuessNumber(Player player1, Player player2, Scanner scanner) {
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = scanner;
    }

    public void play() {
        generateTargetNumber();
        currentPlayer = player1;
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
        targetNumber = minNumber + (int) (Math.random() * (maxNumber - minNumber + 1));
        System.out.printf("\nКомпьютер загадал число в диапазоне [%d, %d]. Попробуйте его угадать!%n",
                minNumber, maxNumber);
    }

    private void makeMove() {
        System.out.println("\nХод игрока " + currentPlayer.getName());
        while (true) {
            readNumber();
            if (isNumberInRange(currentPlayer.getNumber())) {
                break;
            }
            printOutOfRangeWarning();
        }
    }

    private void readNumber() {
        System.out.print("Введите число: ");
        currentPlayer.setNumber(scanner.nextInt());
    }

    private boolean isNumberInRange(int number) {
        return number >= minNumber && number <= maxNumber;
    }

    private void printOutOfRangeWarning() {
        System.out.printf("Внимание! Число должно быть в диапазоне [%d, %d]. Введите другое число.%n",
                minNumber, maxNumber);
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
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private void printVictoryMessage() {
        System.out.printf("\nИскомое число - %d. Побеждает игрок %s!%n%n",
                currentPlayer.getNumber(), currentPlayer.getName());
    }
}