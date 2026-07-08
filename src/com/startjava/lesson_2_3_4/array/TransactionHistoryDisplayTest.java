package com.startjava.lesson_2_3_4.array;

public class TransactionHistoryDisplayTest {
    public static void main(String[] args) {
        int[][] transactionSets = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };

        for (int[] transactionSet : transactionSets) {
            System.out.println();
            TransactionHistoryDisplay.display(transactionSet);
        }
    }
}