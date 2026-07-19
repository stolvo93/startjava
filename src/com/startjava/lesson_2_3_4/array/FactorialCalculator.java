package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    private static final int MAX_INPUT_VALUE = 20;
    private static final int INVALID_NEGATIVE = -1;
    private static final int INVALID_TOO_LARGE = -2;

    public static void main(String[] args) {
        int[][] numberSets = {
                {},
                null,
                {-5},
                {7, 0, 21},
                {1, 20, 5, -3}
        };

        for (int[] numbers : numberSets) {
            System.out.println();
            if (numbers == null) {
                printDataError();
                continue;
            }
            if (numbers.length == 0) {
                printNoNumbersError();
                continue;
            }
            long[] factorials = calculateFactorials(numbers);
            printResults(numbers, factorials);
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка в данных");
    }

    private static void printNoNumbersError() {
        System.out.println("Ошибка: нет чисел для расчета");
    }

    private static long[] calculateFactorials(int[] numbers) {
        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = INVALID_NEGATIVE;
                continue;
            }
            if (numbers[i] > MAX_INPUT_VALUE) {
                factorials[i] = INVALID_TOO_LARGE;
                continue;
            }
            factorials[i] = factorial(numbers[i]);
        }
        return factorials;
    }

    private static long factorial(int number) {
        long factorial = 1L;
        while (number > 1) {
            factorial *= number--;
        }
        return factorial;
    }

    private static void printResults(int[] numbers, long[] factorials) {
        for (int i = 0; i < numbers.length; i++) {
            if (factorials[i] == INVALID_NEGATIVE) {
                printNegativeNumberError(numbers[i]);
                continue;
            }
            if (factorials[i] == INVALID_TOO_LARGE) {
                printTooLargeNumberError(numbers[i]);
                continue;
            }
            printFactorialExpression(numbers[i], factorials[i]);
        }
    }

    private static void printNegativeNumberError(int number) {
        System.out.printf("Ошибка: факториал %d! не определен%n", number);
    }

    private static void printTooLargeNumberError(int number) {
        System.out.printf("Ошибка: факториал %d! слишком велик (максимум %d!)%n", number, MAX_INPUT_VALUE);
    }

    private static void printFactorialExpression(int number, long factorial) {
        StringBuilder expression = new StringBuilder().append(number).append("! = 1");
        for (int i = 2; i <= number; i++) {
            expression.append(" * ").append(i);
        }
        String finalPart = String.format(" = %,d", factorial);
        String finalExpression = (number == 0 || number == 1) ? expression.toString()
                : expression.append(finalPart).toString();
        System.out.println(finalExpression);
    }
}