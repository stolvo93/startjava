import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("\n******* Калькулятор *******");

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String answer = "";

        do {
            System.out.print("\nВведите первое число: ");
            final int firstNumber = scanner.nextInt();

            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            scanner.nextLine();
            final String mathOperator = scanner.nextLine();
            
            System.out.print("Введите второе число: ");
            final int secondNumber = scanner.nextInt();

            calculator.calculate(firstNumber, mathOperator, secondNumber);
            scanner.nextLine();

            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (answer.equals("yes"));
    }
}