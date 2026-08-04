package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] triedNumbers;
    private int number;
    private int latestAttempt;
    private int score;

    public Player(String name) {
        this.name = name;
        triedNumbers = new int[GuessNumber.MAX_ATTEMPTS];
        score = 0;
        System.out.println("Игрок " + name + " создан.");
    }

    public String getName() {
        return name;
    }

    public int[] getTriedNumbers() {
        int actuallyTriedNumbersLength = latestAttempt;
        int[] actuallyTriedNumbers = Arrays.copyOf(triedNumbers, actuallyTriedNumbersLength);
        return actuallyTriedNumbers;
    }

    public void addTriedNumber() {
        int indexToFill = latestAttempt - 1;
        triedNumbers[indexToFill] = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < GuessNumber.MIN_NUMBER || number > GuessNumber.MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "%nОшибка: число должно быть в диапазоне [%d, %d].",
                    GuessNumber.MIN_NUMBER, GuessNumber.MAX_NUMBER));
        }
        this.number = number;
    }

    public int getLatestAttempt() {
        return latestAttempt;
    }

    public void setLatestAttempt(int currentAttempt) {
        latestAttempt = currentAttempt;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }
}