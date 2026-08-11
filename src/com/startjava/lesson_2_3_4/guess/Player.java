package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] triedNumbers;
    private int latestAttempt;
    private int score;

    public Player(String name) {
        this.name = name;
        triedNumbers = new int[GuessNumber.MAX_ATTEMPTS];
        System.out.println("Игрок " + this.name + " создан.");
    }

    public String getName() {
        return name;
    }

    public int[] getTriedNumbers() {
        return Arrays.copyOf(triedNumbers, latestAttempt);
    }

    public int getLatestNumber() {
        int numberIndex = latestAttempt - 1;
        return triedNumbers[numberIndex];
    }

    public void addTriedNumber(int number, int attempt) {
        if (number < GuessNumber.MIN_NUMBER || number > GuessNumber.MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "%nОшибка: число должно быть в диапазоне [%d, %d].",
                    GuessNumber.MIN_NUMBER, GuessNumber.MAX_NUMBER));
        }
        int indexToFill = attempt - 1;
        triedNumbers[indexToFill] = number;
    }

    public void setLatestAttempt(int attempt) {
        latestAttempt = attempt;
    }

    public void resetLatestAttempt() {
        latestAttempt = 0;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }
}