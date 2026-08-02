package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int MAX_ATTEMPTS = 10;
    private final String name;
    private final int[] pastNumbers;
    private int number;
    private int attemptsRemaining;
    private int attemptNumber;

    public Player(String name) {
        this.name = name;
        pastNumbers = new int[MAX_ATTEMPTS];
        attemptsRemaining = MAX_ATTEMPTS;
        attemptNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int[] getPastNumbers() {
        int usedNumbersLength = MAX_ATTEMPTS - attemptsRemaining;
        int[] usedNumbers = Arrays.copyOf(pastNumbers, usedNumbersLength);
        return usedNumbers;
    }

    public void addPastNumber(int number) {
        int indexToFill = MAX_ATTEMPTS - attemptsRemaining;
        pastNumbers[indexToFill] = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < GuessNumber.MIN_NUMBER || number > GuessNumber.MAX_NUMBER) {
            throw new NumberNotInRangeException(String.format(
                    "Ошибка: число должно быть в диапазоне [%d, %d].",
                    GuessNumber.MIN_NUMBER, GuessNumber.MAX_NUMBER));
        }
        this.number = number;
    }

    public void decrementAttempts() {
        if (attemptsRemaining > 0) attemptsRemaining--;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void incrementAttemptNumber() {
        if (attemptNumber < MAX_ATTEMPTS) attemptNumber++;
    }
}