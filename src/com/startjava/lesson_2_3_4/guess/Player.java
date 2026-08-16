package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] triedNumbers;
    private int attemptsMade;
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
        return Arrays.copyOf(triedNumbers, attemptsMade);
    }

    public int getLatestNumber() {
        int numberIndex = attemptsMade - 1;
        return triedNumbers[numberIndex];
    }

    public void recordAttempt(int number) {
        if (number < GuessNumber.MIN_NUMBER || number > GuessNumber.MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "%nОшибка: число должно быть в диапазоне [%d, %d].",
                    GuessNumber.MIN_NUMBER, GuessNumber.MAX_NUMBER));
        }
        triedNumbers[attemptsMade] = number;
        attemptsMade++;
    }

    public void resetAttempts() {
        attemptsMade = 0;
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