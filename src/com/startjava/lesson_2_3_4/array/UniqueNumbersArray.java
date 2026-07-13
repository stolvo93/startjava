package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[] randomArray = generateUniqueNumbersArray(3, 25);
        System.out.println(Arrays.toString(randomArray));
        System.out.println(randomArray.length);
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
}