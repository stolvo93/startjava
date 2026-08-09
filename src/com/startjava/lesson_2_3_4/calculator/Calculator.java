package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int VALID_ELEMENTS_NUMBER = 3;

    public static double calculate(String mathExpression) {
        final String[] expressionElements = mathExpression.split("\\s");
        if (expressionElements.length != VALID_ELEMENTS_NUMBER) {
            throw new WrongElementsNumberException(
                    "Ошибка: неверное количество элементов выражения (должно быть " +
                            VALID_ELEMENTS_NUMBER + ")");
        }
        final String mathOperator = expressionElements[1];
        final int a = parseInt(expressionElements[0]);
        final int b = parseInt(expressionElements[2]);

        return switch (mathOperator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> div(a, b);
            case "%" -> mod(a, b);
            case "^" -> pow(a, b);
            default -> throw new UnsupportedOperatorException(
                    "Ошибка: оператор '" + mathOperator + "' не поддерживается");
        };
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка: " + string + " не является целым числом");
        }
    }

    private static double div(int dividend, int divisor) {
        checkDivisionByZero(divisor);
        return (double) dividend / divisor;
    }

    private static double mod(int dividend, int divisor) {
        checkDivisionByZero(divisor);
        return Math.floorMod(dividend, divisor);
    }

    private static void checkDivisionByZero(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Ошибка: деление на 0 запрещено");
        }
    }

    private static double pow(int base, int power) {
        if (base == 0 && power < 0) {
            throw new ArithmeticException(
                    "Ошибка: возведение 0 в отрицательную степень запрещено (аналогично делению на 0)");
        }
        return Math.pow(base, power);
    }
}