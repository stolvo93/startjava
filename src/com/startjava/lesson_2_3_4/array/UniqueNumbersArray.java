package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[][] inputValues = {
                {-30, -10, 23},
                {10, 50, 10},
                {-34, -34, 1},
                {-1, 2, -3},
                {5, -8, 2},
        };
        for (int[] values : inputValues) {
            System.out.println();
            print(values[0], values[1], values[2]);
        }
    }

    private static void print(int leftBound, int rightBound, int lineLength) {
        if (lineLength < 1) {
            printInvalidLineLengthError(lineLength);
            return;
        }

        int rangeSize = rightBound - leftBound + 1;
        int arrayLength = rangeSize * 3 / 4;
        if (arrayLength <= 0) {
            printInvalidArrayLength(arrayLength);
            if (leftBound > rightBound) {
                printLeftBoundIsGreaterError(leftBound, rightBound);
            }
            return;
        }

        int[] uniqueNumbers = generateUniqueNumbersArray(leftBound, rightBound);
        printSortedNumbers(uniqueNumbers, lineLength);
    }

    private static void printInvalidLineLengthError(int lineLength) {
        System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n", lineLength);
    }

    private static void printInvalidArrayLength(int arrayLength) {
        System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n", arrayLength);
    }

    private static void printLeftBoundIsGreaterError(int leftBound, int rightBound) {
        System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", leftBound, rightBound);
    }

    private static int[] generateUniqueNumbersArray(int leftBound, int rightBound) {
        int rangeSize = rightBound - leftBound + 1;
        int length = rangeSize * 3 / 4;
        int[] randomUniqueNumbers = new int[length];
        Random random = new Random();
        int uniqueNumbersCount = 0;
        while (uniqueNumbersCount < length) {
            int newNumber = random.nextInt(rangeSize) + leftBound;
            boolean isDuplicate = false;
            for (int i = 0; i < uniqueNumbersCount; i++) {
                if (randomUniqueNumbers[i] == newNumber) {
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
            sb.append(numbers[i]).append(", ");
            if ((i + 1) % lineLength == 0) {
                sb.append("\n");
            }
        }
        sb.append(numbers[numbers.length - 1]);
        System.out.println(sb);
    }
}