package com.startjava.lesson_2_3_4.array;

public class TransactionHistoryDisplay {
    public static void displayForwardAndReverseOrder(Integer[] transactions) {
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

    private static void printTransactions(Integer[] transactions) {
        System.out.print("Исходные транзакции: ");
        System.out.println(representCommaSeparatedInBrackets(transactions));
        System.out.print(" В обратном порядке: ");
        System.out.println(representCommaSeparatedInBrackets(reverse(transactions)));
    }

    private static String representCommaSeparatedInBrackets(Integer[] transactions) {
        int index = 0;
        String finalRepresentation = "[";
        while (index < transactions.length - 1) {
            finalRepresentation += transactions[index++] + ", ";
        }
        finalRepresentation += transactions[index] + "]";
        return finalRepresentation;
    }

    private static int[] reverse(Integer[] original) {
        int[] reversed = new int[original.length];
        int index = reversed.length - 1;
        for (int element : original) {
            reversed[index--] = element;
        }
        return reversed;
    }
}
