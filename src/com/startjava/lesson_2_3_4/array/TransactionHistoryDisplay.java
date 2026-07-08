package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionHistoryDisplay {
    public static void display(int[] transactions) {
        if (transactions == null) {
            printDataError();
        } else if (transactions.length == 0) {
            printNoDataMessage();
        } else {
            printTransactions(transactions);
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка в данных.");
    }

    private static void printNoDataMessage() {
        System.out.println("Нет данных.");
    }

    private static void printTransactions(int[] transactions) {
        System.out.print("Исходные транзакции: ");
        System.out.println(Arrays.toString(transactions));
        System.out.print(" В обратном порядке: ");
        System.out.println(Arrays.toString(reverse(transactions)));
    }

    private static int[] reverse(int[] original) {
        int[] reversed = new int[original.length];
        int index = reversed.length - 1;
        for (int element : original) {
            reversed[index--] = element;
        }
        return reversed;
    }
}