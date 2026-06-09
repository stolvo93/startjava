class Calculator {
    public static void main(String[] args) {
        System.out.println("\n******* Калькулятор *******\n");

        int firstNumber = 4;
        char mathOperator = '^';
        int secondNumber = 3;
        double result = 0;
        String resultMessage = "%d %c %d = %.0f%n%n";

        if (firstNumber < 1 || secondNumber < 1) {
            System.out.println("Ошибка: операнды должны быть натуральными числами.\n");
        } else if (mathOperator == '+') {
            result = firstNumber + secondNumber;
            System.out.printf(resultMessage, firstNumber, mathOperator, secondNumber, result);
        } else if (mathOperator == '-') {
            result = firstNumber - secondNumber;
            System.out.printf(resultMessage, firstNumber, mathOperator, secondNumber, result);
        } else if (mathOperator == '*') {
            result = firstNumber * secondNumber;
            System.out.printf(resultMessage, firstNumber, mathOperator, secondNumber, result);
        } else if (mathOperator == '/') {
            result = (double) firstNumber / secondNumber;
            System.out.printf("%d %c %d = %.2f%n%n", firstNumber, mathOperator, secondNumber, result);
        } else if (mathOperator == '%') {
            result = firstNumber % secondNumber;
            System.out.printf(resultMessage, firstNumber, mathOperator, secondNumber, result);
        } else if (mathOperator == '^') {
            result = firstNumber;
            if (secondNumber != 1) {
                double base = firstNumber;
                for (int i = 2; i <= secondNumber; i++) {
                    result *= base;
                }
            }
            System.out.printf(resultMessage, firstNumber, mathOperator, secondNumber, result);
        } else {
            System.out.println("Ошибка: неверный математический оператор");
        }
    }
}