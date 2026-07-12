package com.startjava.lesson_2_3_4.array;

public class Factorials {
    private static final int INVALID_NEGATIVE = -1;
    private static final int INVALID_TOO_LARGE = -2;

    public static void main(String[] args) {
        Factorials.print();
        Factorials.print(null);
        Factorials.print(-5);
        Factorials.print(7, 0, 21);
        Factorials.print(1, 20, 5, -3);
    }

    private static void print(int... numbers) {
        System.out.println();
        if (numbers == null) {
            printDataError();
            return;
        }
        if (numbers.length == 0) {
            printNoNumbersError();
        } else {
            long[] factorials = calculateFactorials(numbers);
            printOutput(numbers, factorials);
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка в данных");
    }

    private static void printNoNumbersError() {
        System.out.println("Ошибка: нет чисел для расчета");
    }

    private static void printOutput(int[] numbers, long[] factorials) {
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

    private static void printFactorialExpression(int number, long factorial) {
        StringBuilder sb = new StringBuilder().append(number).append("! = 1");
        for (int i = 2; i <= number; i++) {
            sb.append(" * ").append(i);
        }
        String finalPart = String.format(" = %,d", factorial);
        String expression = number == 0 || number == 1 ? sb.toString()
                : sb.append(finalPart).toString();
        System.out.println(expression);
    }

    private static long[] calculateFactorials(int[] numbers) {
        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                factorials[i] = INVALID_NEGATIVE;
                continue;
            }
            if (numbers[i] > 20) {
                factorials[i] = INVALID_TOO_LARGE;
                continue;
            }
            factorials[i] = factorial(numbers[i]);
        }
        return factorials;
    }

    private static void printNegativeNumberError(int number) {
        System.out.printf("Ошибка: факториал %d! не определен%n", number);
    }

    private static void printTooLargeNumberError(int number) {
        System.out.printf("Ошибка: факториал %d! слишком велик (максимум 20!)%n", number);
    }

    private static long factorial(int number) {
        long factorial = 1L;
        while (number > 1) {
            factorial *= number--;
        }
        return factorial;
    }
}