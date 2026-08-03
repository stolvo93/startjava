package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] triedNumbers;
    private int number;

    public Player(String name) {
        this.name = name;
        triedNumbers = new int[GuessNumber.MAX_ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int[] getTriedNumbers(int lastAttempt) {
        int actuallyTriedNumbersLength = lastAttempt - 1;
        int[] actuallyTriedNumbers = Arrays.copyOf(triedNumbers, actuallyTriedNumbersLength);
        return actuallyTriedNumbers;
    }

    public void addTriedNumber(int currentAttempt) {
        int indexToFill = currentAttempt - 1;
        triedNumbers[indexToFill] = number;
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
}