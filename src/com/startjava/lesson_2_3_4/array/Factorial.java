package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void printFactorials(int... nums) {
        if (nums == null) {
            printDataError();
            return;
        }
        if (nums.length == 0) {
            printNoDataMessage();
        } else {
            printOutput(nums, getFactorials(nums));
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка в данных");
    }

    private static void printNoDataMessage() {
        System.out.println("Ошибка: нет чисел для расчета");
    }

    private static void printOutput(int[] nums, long[] factorials) {
        for (int i = 0; i < nums.length; i++) {
            if (factorials[i] > 0) {
                printFactorialExpression(nums[i], factorials[i]);
            }
        }
    }

    private static void printFactorialExpression(int num, long factorial) {
        StringBuilder sb = new StringBuilder().append(num).append("! = 1");
        for (int i = 2; i <= num; i++) {
            sb.append(" * ").append(i);
        }
        String expression = num == 0 || num == 1 ? sb.toString()
                : sb.append(" = ").append(factorial).toString();
        System.out.println(expression);
    }

    private static long[] getFactorials(int[] nums) {
        long[] factorials = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                printNegativeNumberError(nums[i]);
                break;
            }
            if (nums[i] > 20) {
                printTooLargeNumberError(nums[i]);
                break;
            }
            factorials[i] = factorial(nums[i]);
        }
        return factorials;
    }

    private static void printNegativeNumberError(int num) {
        System.out.printf("Ошибка: факториал %d! не определен%n", num);
    }

    private static void printTooLargeNumberError(int num) {
        System.out.printf("Ошибка: факториал %d! слишком велик (максимум 20!)%n", num);
    }

    private static long factorial(int num) {
        long factorial = 1L;
        while (num > 1) {
            factorial *= num--;
        }
        return factorial;
    }
}