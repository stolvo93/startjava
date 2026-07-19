package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionHistoryDisplay {
    public static void main(String[] args) {
        int[][] transactionSets = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };

        for (int[] transactions : transactionSets) {
            System.out.println();
            if (transactions == null) {
                printDataError();
            } else if (transactions.length == 0) {
                printNoDataMessage();
            } else {
                printTransactions(transactions, reverse(transactions));
            }
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка в данных.");
    }

    private static void printNoDataMessage() {
        System.out.println("Нет данных.");
    }

    private static int[] reverse(int[] original) {
        int[] reversed = new int[original.length];
        int index = reversed.length - 1;
        for (int element : original) {
            reversed[index--] = element;
        }
        return reversed;
    }

    private static void printTransactions(int[] transactions, int[] reversedTransactions) {
        System.out.printf("Исходные транзакции: %s%n", Arrays.toString(transactions));
        System.out.printf(" В обратном порядке: %s%n", Arrays.toString(reversedTransactions));
    }
}