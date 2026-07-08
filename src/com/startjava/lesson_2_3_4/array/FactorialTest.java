package com.startjava.lesson_2_3_4.array;

public class FactorialTest {
    public static void main(String[] args) {
        int[][] numberSets = {
                {},
                null,
                {-5},
                {7, 0, 21},
                {1, 20, 5, -3}
        };

        for (int[] numberSet : numberSets) {
            System.out.println();
            Factorial.printFactorials(numberSet);
        }
    }
}
