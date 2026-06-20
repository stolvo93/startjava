import java.text.DecimalFormat;

public class Calculator {
    private int firstNumber;
    private String mathOperator;
    private int secondNumber;
    private double result;

    private void setFirstNumber(int number) {
        firstNumber = number;
    }

    private void setMathOperator(String mathOperator) {
        this.mathOperator = mathOperator;
    }

    private void setSecondNumber(int number) {
        secondNumber = number;
    }

    public void calculate(int firstNumber, String mathOperator, int secondNumber) {
        setFirstNumber(firstNumber);
        setMathOperator(mathOperator);
        setSecondNumber(secondNumber);

        switch (mathOperator) {
            case "+":
                result = add();
                break;
            case "-":
                result = subtract();
                break;
            case "*":
                result = multiply();
                break;
            case "/":
                result = divide();
                if (Double.isNaN(result)) return;
                break;
            case "%":
                result = mod();
                break;
            case "^":
                result = pow();
                break;
            default:
                System.out.println("Ошибка: операция '" + mathOperator + "' не поддерживается");
                return;
        }

        printResult();
    }

    private double add() {
        return firstNumber + secondNumber;
    }

    private double subtract() {
        return firstNumber - secondNumber;
    }

    private double multiply() {
        return firstNumber * secondNumber;
    }

    private double divide() {
        if (secondNumber != 0) {
            return (double) firstNumber / secondNumber;
        } else {
            System.out.println("Ошибка: деление на ноль запрещено!");
            return Double.NaN;
        }
    }

    private int mod() {
        return firstNumber % secondNumber;
    }

    private double pow() {
        int product = 1;
        int power = secondNumber >= 0 ? secondNumber : -secondNumber;

        for (int i = 1; i <= power; i++) {
            product *= firstNumber;
        }

        if (secondNumber < 0) {
            product = 1 / product;
        }

        return product;
    }

    private void printResult() {
        DecimalFormat df = new DecimalFormat("0.########");
        String resultFormatted = df.format(result);
        System.out.printf("%d %s %d = %s%n", firstNumber, mathOperator, secondNumber, resultFormatted);
    }
}