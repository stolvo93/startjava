package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[][] argumentSets = {
                {-30, -10, 23},
                {10, 50, 10},
                {-34, -34, 1},
                {-1, 2, -3},
                {5, -8, 2},
        };
        for (int[] argumentSet : argumentSets) {
            System.out.println();
            print(argumentSet[0], argumentSet[1], argumentSet[2]);
        }
    }

    private static void print(int leftBound, int rightBound, int lineLength) {
        if (lineLength < 1) {
            printInvalidLineLengthError(lineLength);
            return;
        }
        if (leftBound > rightBound) {
            printLeftBoundIsGreaterError(leftBound, rightBound);
            return;
        }
        int rangeSize = rightBound - leftBound + 1;
        int arrayLength = rangeSize * 3 / 4;
        if (arrayLength <= 0) {
            printInvalidArrayLength(arrayLength);
            return;
        }

        int[] uniqueNumbers = generateUniqueNumbersArray(leftBound, rangeSize, arrayLength);
        printSortedNumbers(uniqueNumbers, lineLength);
    }

    private static void printInvalidLineLengthError(int lineLength) {
        System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n", lineLength);
    }

    private static void printLeftBoundIsGreaterError(int leftBound, int rightBound) {
        System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", leftBound, rightBound);
    }

    private static void printInvalidArrayLength(int arrayLength) {
        System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n", arrayLength);
    }

    private static int[] generateUniqueNumbersArray(int minValue, int rangeSize, int arrayLength) {
        int[] randomUniqueNumbers = new int[arrayLength];
        int uniqueNumbersCount = 0;
        Random random = new Random();
        while (uniqueNumbersCount < arrayLength) {
            int newNumber = random.nextInt(rangeSize) + minValue;
            boolean isDuplicate = false;
            for (int i = 0; i < uniqueNumbersCount; i++) {
                if (newNumber == randomUniqueNumbers[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                continue;
            } else {
                randomUniqueNumbers[uniqueNumbersCount++] = newNumber;
            }
        }
        return randomUniqueNumbers;
    }

    private static void printSortedNumbers(int[] numbers, int lineLength) {
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder("Числа, отсортированные по возрастанию:\n");
        for (int i = 0; i < numbers.length - 1; i++) {
            sb.append(numbers[i]).append(" ");
            if ((i + 1) % lineLength == 0) {
                sb.append("\n");
            }
        }
        sb.append(numbers[numbers.length - 1]);
        System.out.println(sb);
    }
}