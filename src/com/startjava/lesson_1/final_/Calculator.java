package com.startjava.lesson_1.final_;

class Calculator {
    public static void main(String[] args) {
        System.out.println("\n******* Калькулятор *******\n");

        int firstNumber = 44;
        char mathOperator = '^';
        int secondNumber = 3;
        double result = 0;
        String resultFormat = "%d %c %d = %,.0f%n%n";

        if (firstNumber < 1 || secondNumber < 1) {
            System.out.println("Ошибка: операнды должны быть натуральными числами.\n");
            return;
        }

        if (mathOperator == '+') {
            result = firstNumber + secondNumber;
        } else if (mathOperator == '-') {
            result = firstNumber - secondNumber;
        } else if (mathOperator == '*') {
            result = firstNumber * secondNumber;
        } else if (mathOperator == '/') {
            result = (double) firstNumber / secondNumber;
            resultFormat = "%d %c %d = %.2f%n%n";
        } else if (mathOperator == '%') {
            result = firstNumber % secondNumber;
        } else if (mathOperator == '^') {
            result = firstNumber;
            if (secondNumber != 1) {
                double base = firstNumber;
                for (int i = 2; i <= secondNumber; i++) {
                    result *= base;
                }
            }
        } else {
            System.out.println("Ошибка: неверный математический оператор");
            return;
        }

        System.out.printf(resultFormat, firstNumber, mathOperator, secondNumber, result);
    }
}