package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class CalculatorTest {
    private static final char[] MATH_OPERATORS = "+-*/%^".toCharArray();
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("\n******* Калькулятор *******");

        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            String prompt = generatePrompt();
            String expression = readCleanInput(scanner, prompt);
            try {
                double result = Calculator.calculate(expression);
                printResult(expression, result);
            } catch (WrongElementsNumberException | IllegalArgumentException |
                     ArithmeticException | UnsupportedOperatorException e) {
                System.out.println(e.getMessage());
            }
            answer = askToContinue(scanner);
        } while ("yes".equals(answer));
    }

    private static String generatePrompt() {
        String example = generateExample();
        return String.format("\nВведите выражение из трех элементов через пробел, например, %s: ", example);
    }

    private static String generateExample() {
        byte number1 = generateByteNumber();
        char mathOperator = MATH_OPERATORS[random.nextInt(MATH_OPERATORS.length)];
        byte number2 = mathOperator == '/' || mathOperator == '%' ?
                generateNonZeroByteNumber() : generateByteNumber();
        return String.join(" ",
                String.valueOf(number1), String.valueOf(mathOperator), String.valueOf(number2));
    }

    private static byte generateByteNumber() {
        return (byte) random.nextInt();
    }

    private static byte generateNonZeroByteNumber() {
        byte randomNumber = generateByteNumber();
        if (randomNumber == 0) return generateNonZeroByteNumber();
        return randomNumber;
    }

    private static String readCleanInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim().replaceAll("\\s+", " ");
    }

    private static void printResult(String expression, double result) {
        DecimalFormat df = new DecimalFormat("0.###");
        String resultFormatted = df.format(result);
        System.out.printf("%s = %s%n", expression, resultFormatted);
    }

    private static String askToContinue(Scanner scanner) {
        return askToContinue(scanner, "\nХотите продолжить вычисления? [yes / no]: ");
    }

    private static String askToContinue(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String answer = scanner.nextLine().trim().toLowerCase();
        if (!"yes".equals(answer) && !"no".equals(answer)) {
            return askToContinue(scanner, "Введите корректный ответ [yes / no]: ");
        }
        return answer;
    }
}